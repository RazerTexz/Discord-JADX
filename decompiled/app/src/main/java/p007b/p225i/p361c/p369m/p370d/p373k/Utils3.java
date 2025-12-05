package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Looper;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: Utils.java */
/* renamed from: b.i.c.m.d.k.h1, reason: use source file name */
/* loaded from: classes3.dex */
public final class Utils3 {

    /* renamed from: a */
    public static final FilenameFilter f12313a = new a();

    /* renamed from: b */
    public static final ExecutorService f12314b = C3404f.m4319n("awaitEvenIfOnMainThread task continuation executor");

    /* compiled from: Utils.java */
    /* renamed from: b.i.c.m.d.k.h1$a */
    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    /* renamed from: a */
    public static <T> T m6432a(Task<T> task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.mo6014i(f12314b, new Utils2(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (task.mo6021p()) {
            return task.mo6017l();
        }
        if (task.mo6019n()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.mo6020o()) {
            throw new IllegalStateException(task.mo6016k());
        }
        throw new TimeoutException();
    }

    /* renamed from: b */
    public static int m6433b(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] fileArrListFiles = file.listFiles(filenameFilter);
        if (fileArrListFiles == null) {
            return 0;
        }
        return m6434c(Arrays.asList(fileArrListFiles), i, comparator);
    }

    /* renamed from: c */
    public static int m6434c(List<File> list, int i, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File file : list) {
            if (size <= i) {
                return size;
            }
            m6435d(file);
            size--;
        }
        return size;
    }

    /* renamed from: d */
    public static void m6435d(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m6435d(file2);
            }
        }
        file.delete();
    }
}
