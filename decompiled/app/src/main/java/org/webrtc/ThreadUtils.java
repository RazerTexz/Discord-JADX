package org.webrtc;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadUtils {

    /* JADX INFO: renamed from: org.webrtc.ThreadUtils$1 */
    public class C129911 implements BlockingOperation {
        public final /* synthetic */ Thread val$thread;

        public C129911(Thread thread) {
            this.val$thread = thread;
        }

        @Override // org.webrtc.ThreadUtils.BlockingOperation
        public void run() throws InterruptedException {
            this.val$thread.join();
        }
    }

    /* JADX INFO: renamed from: org.webrtc.ThreadUtils$1CaughtException, reason: invalid class name */
    public class C1CaughtException {

        /* JADX INFO: renamed from: e */
        public Exception f27618e;
    }

    /* JADX INFO: renamed from: org.webrtc.ThreadUtils$1Result, reason: invalid class name */
    public class C1Result {
        public V value;
    }

    /* JADX INFO: renamed from: org.webrtc.ThreadUtils$2 */
    public class C129922 implements BlockingOperation {
        public final /* synthetic */ CountDownLatch val$latch;

        public C129922(CountDownLatch countDownLatch) {
            this.val$latch = countDownLatch;
        }

        @Override // org.webrtc.ThreadUtils.BlockingOperation
        public void run() throws InterruptedException {
            this.val$latch.await();
        }
    }

    /* JADX INFO: renamed from: org.webrtc.ThreadUtils$3 */
    public class RunnableC129933 implements Runnable {
        public final /* synthetic */ CountDownLatch val$barrier;
        public final /* synthetic */ Callable val$callable;
        public final /* synthetic */ C1CaughtException val$caughtException;
        public final /* synthetic */ C1Result val$result;

        public RunnableC129933(C1Result c1Result, Callable callable, C1CaughtException c1CaughtException, CountDownLatch countDownLatch) {
            this.val$result = c1Result;
            this.val$callable = callable;
            this.val$caughtException = c1CaughtException;
            this.val$barrier = countDownLatch;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [V, java.lang.Object] */
        @Override // java.lang.Runnable
        public void run() {
            try {
                this.val$result.value = this.val$callable.call();
            } catch (Exception e) {
                this.val$caughtException.f27618e = e;
            }
            this.val$barrier.countDown();
        }
    }

    /* JADX INFO: renamed from: org.webrtc.ThreadUtils$4 */
    public class CallableC129944 implements Callable<Void> {
        public final /* synthetic */ Runnable val$runner;

        public CallableC129944(Runnable runnable) {
            this.val$runner = runnable;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() {
            this.val$runner.run();
            return null;
        }
    }

    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    public static class ThreadChecker {

        @Nullable
        private Thread thread = Thread.currentThread();

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = Thread.currentThread();
            }
            if (Thread.currentThread() != this.thread) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void detachThread() {
            this.thread = null;
        }
    }

    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        executeUninterruptibly(new C129922(countDownLatch));
    }

    public static void checkIsOnMainThread() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("Not on main thread!");
        }
    }

    public static StackTraceElement[] concatStackTraces(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[stackTraceElementArr.length + stackTraceElementArr2.length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr3, 0, stackTraceElementArr.length);
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, stackTraceElementArr.length, stackTraceElementArr2.length);
        return stackTraceElementArr3;
    }

    public static void executeUninterruptibly(BlockingOperation blockingOperation) {
        boolean z2 = false;
        while (true) {
            try {
                blockingOperation.run();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public static <V> V invokeAtFrontUninterruptibly(Handler handler, Callable<V> callable) {
        if (handler.getLooper().getThread() == Thread.currentThread()) {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        C1Result c1Result = new C1Result();
        C1CaughtException c1CaughtException = new C1CaughtException();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new RunnableC129933(c1Result, callable, c1CaughtException, countDownLatch));
        awaitUninterruptibly(countDownLatch);
        if (c1CaughtException.f27618e == null) {
            return c1Result.value;
        }
        RuntimeException runtimeException = new RuntimeException(c1CaughtException.f27618e);
        runtimeException.setStackTrace(concatStackTraces(c1CaughtException.f27618e.getStackTrace(), runtimeException.getStackTrace()));
        throw runtimeException;
    }

    public static boolean joinUninterruptibly(Thread thread, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z2 = false;
        long jElapsedRealtime2 = j;
        while (jElapsedRealtime2 > 0) {
            try {
                thread.join(jElapsedRealtime2);
                break;
            } catch (InterruptedException unused) {
                jElapsedRealtime2 = j - (SystemClock.elapsedRealtime() - jElapsedRealtime);
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zAwait = false;
        long jElapsedRealtime2 = j;
        boolean z2 = false;
        do {
            try {
                zAwait = countDownLatch.await(jElapsedRealtime2, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException unused) {
                z2 = true;
                jElapsedRealtime2 = j - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            }
        } while (jElapsedRealtime2 > 0);
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return zAwait;
    }

    public static void joinUninterruptibly(Thread thread) {
        executeUninterruptibly(new C129911(thread));
    }

    public static void invokeAtFrontUninterruptibly(Handler handler, Runnable runnable) {
        invokeAtFrontUninterruptibly(handler, new CallableC129944(runnable));
    }
}
