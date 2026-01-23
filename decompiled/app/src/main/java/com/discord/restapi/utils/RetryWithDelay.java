package com.discord.restapi.utils;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import okhttp3.Request;
import okhttp3.Response;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import retrofit2.HttpException;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RetryWithDelay {
    public static final RetryWithDelay INSTANCE = new RetryWithDelay();

    /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$1 */
    /* JADX INFO: compiled from: RetryWithDelay.kt */
    public static final class C55931 extends Lambda implements Function1<Throwable, Boolean> {
        public static final C55931 INSTANCE = new C55931();

        public C55931() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(invoke2(th));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Throwable th) {
            Response response;
            Request request;
            String str;
            Intrinsics3.checkNotNullParameter(th, "throwable");
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                int iM11055a = httpException.m11055a();
                retrofit2.Response<?> response2 = httpException.f27630j;
                if ((response2 != null && (response = response2.f27631a) != null && (request = response.request) != null && (str = request.method) != null && (!Intrinsics3.areEqual(str, ShareTarget.METHOD_GET))) || iM11055a == 401 || iM11055a == 429 || iM11055a == 503 || iM11055a == 403 || iM11055a == 404) {
                    return false;
                }
            } else if (th instanceof TimeoutException) {
                return false;
            }
            return th instanceof IOException;
        }
    }

    /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$2 */
    /* JADX INFO: compiled from: RetryWithDelay.kt */
    public static final class C55942<T, R> implements Func1<Observable<? extends Throwable>, Observable<?>> {
        public final /* synthetic */ long $delayMillis;
        public final /* synthetic */ Integer $maxHalfLives;
        public final /* synthetic */ Integer $maxRetries;

        /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RetryWithDelay.kt */
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Throwable, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1, null, "isNetworkError", "invoke(Ljava/lang/Throwable;)Z", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
                return Boolean.valueOf(invoke2(th));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Throwable th) {
                Intrinsics3.checkNotNullParameter(th, "p1");
                return C55931.INSTANCE.invoke2(th);
            }
        }

        public C55942(long j, Integer num, Integer num2) {
            this.$delayMillis = j;
            this.$maxHalfLives = num;
            this.$maxRetries = num2;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Throwable> observable) {
            return call2(observable);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<?> call2(Observable<? extends Throwable> observable) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(observable, "it");
            return RetryWithDelay.access$retryWithDelay(retryWithDelay, observable, this.$delayMillis, this.$maxHalfLives, this.$maxRetries, AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$restRetry$3 */
    /* JADX INFO: compiled from: RetryWithDelay.kt */
    public static final class C55953<T, R> implements Func1<Observable<? extends Throwable>, Observable<?>> {
        public final /* synthetic */ long $delayMillis;
        public final /* synthetic */ Integer $maxHalfLives;
        public final /* synthetic */ Integer $maxRetries;
        public final /* synthetic */ Function1 $predicate;

        public C55953(long j, Integer num, Integer num2, Function1 function1) {
            this.$delayMillis = j;
            this.$maxHalfLives = num;
            this.$maxRetries = num2;
            this.$predicate = function1;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<?> call(Observable<? extends Throwable> observable) {
            return call2(observable);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<?> call2(Observable<? extends Throwable> observable) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(observable, "it");
            return RetryWithDelay.access$retryWithDelay(retryWithDelay, observable, this.$delayMillis, this.$maxHalfLives, this.$maxRetries, this.$predicate);
        }
    }

    /* JADX INFO: renamed from: com.discord.restapi.utils.RetryWithDelay$retryWithDelay$1 */
    /* JADX INFO: compiled from: RetryWithDelay.kt */
    public static final class C55961<T, R> implements Func1<Throwable, Observable<? extends Object>> {
        public final /* synthetic */ Ref$LongRef $currentDelayMillis;
        public final /* synthetic */ Ref$IntRef $currentHalfLife;
        public final /* synthetic */ Ref$IntRef $currentRetry;
        public final /* synthetic */ int $maxHalfLives;
        public final /* synthetic */ int $maxRetries;
        public final /* synthetic */ Function1 $retryPredicate;

        public C55961(int i, Ref$IntRef ref$IntRef, Function1 function1, int i2, Ref$IntRef ref$IntRef2, Ref$LongRef ref$LongRef) {
            this.$maxRetries = i;
            this.$currentRetry = ref$IntRef;
            this.$retryPredicate = function1;
            this.$maxHalfLives = i2;
            this.$currentHalfLife = ref$IntRef2;
            this.$currentDelayMillis = ref$LongRef;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Object> call(Throwable th) {
            return call2(th);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Object> call2(Throwable th) {
            Ref$IntRef ref$IntRef = this.$currentRetry;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            if (i < this.$maxRetries) {
                Function1 function1 = this.$retryPredicate;
                Intrinsics3.checkNotNullExpressionValue(th, "it");
                if (((Boolean) function1.invoke(th)).booleanValue()) {
                    Ref$IntRef ref$IntRef2 = this.$currentHalfLife;
                    int i2 = ref$IntRef2.element;
                    int i3 = i2 + 1;
                    ref$IntRef2.element = i3;
                    if (i2 < this.$maxHalfLives && i3 > 1) {
                        this.$currentDelayMillis.element *= (long) 2;
                    }
                    return Observable.m11068d0(this.$currentDelayMillis.element, TimeUnit.MILLISECONDS);
                }
            }
            return Observable.m11081x(th);
        }
    }

    private RetryWithDelay() {
    }

    public static final /* synthetic */ Observable access$retryWithDelay(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, Function1 function1) {
        return retryWithDelay.retryWithDelay(observable, j, num, num2, function1);
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2);
    }

    private final Observable<Object> retryWithDelay(Observable<? extends Throwable> observable, long j, Integer num, Integer num2, Function1<? super Throwable, Boolean> function1) {
        int iIntValue = num2 != null ? num2.intValue() : Integer.MAX_VALUE;
        int iIntValue2 = num != null ? num.intValue() : Integer.MAX_VALUE;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = 0;
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = j;
        Observable<R> observableM11082A = observable.m11082A(new C55961(iIntValue, ref$IntRef, function1, iIntValue2, ref$IntRef2, ref$LongRef));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "flatMap {\n      if (curr…able.error<Any>(it)\n    }");
        return observableM11082A;
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, long j, Integer num, Integer num2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restRetry");
        C55931 c55931 = C55931.INSTANCE;
        Observable<T> observableM11089O = observable.m11089O(new C55942(j, num, num2));
        Intrinsics3.checkNotNullExpressionValue(observableM11089O, "retryWhen { it.retryWith…ries, ::isNetworkError) }");
        return observableM11089O;
    }

    public static /* synthetic */ Observable restRetry$default(RetryWithDelay retryWithDelay, Observable observable, long j, Integer num, Integer num2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = 3;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            num2 = 3;
        }
        return retryWithDelay.restRetry(observable, j2, num3, num2, function1);
    }

    public final <T> Observable<T> restRetry(Observable<T> observable, long j, Integer num, Integer num2, Function1<? super Throwable, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restRetry");
        Intrinsics3.checkNotNullParameter(function1, "predicate");
        Observable<T> observableM11089O = observable.m11089O(new C55953(j, num, num2, function1));
        Intrinsics3.checkNotNullExpressionValue(observableM11089O, "retryWhen { it.retryWith… maxRetries, predicate) }");
        return observableM11089O;
    }
}
