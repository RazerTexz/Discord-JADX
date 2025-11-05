package com.discord.utilities.colors;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.a.g.a;
import b.a.g.d;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.l;
import d0.o;
import d0.t.h0;
import d0.w.h.c;
import d0.w.i.a.b;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import s.a.a.n;
import s.a.k0;
import s.a.x0;

/* compiled from: RepresentativeColors.kt */
/* loaded from: classes2.dex */
public final class RepresentativeColors<T> {
    private final HashMap<T, Integer> representativeColors = new HashMap<>();
    private final BehaviorSubject<Map<T, Integer>> representativeColorsSubject = BehaviorSubject.k0();
    private static final int BLURPLE = Color.parseColor("#5865f2");

    /* compiled from: RepresentativeColors.kt */
    public static final class NoSwatchesFoundException extends RuntimeException {
    }

    /* compiled from: RepresentativeColors.kt */
    public static abstract class RepresentativeColorResult {

        /* compiled from: RepresentativeColors.kt */
        public static final /* data */ class Failure extends RepresentativeColorResult {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(Exception exc) {
                super(null);
                m.checkNotNullParameter(exc, "exception");
                this.exception = exc;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, Exception exc, int i, Object obj) {
                if ((i & 1) != 0) {
                    exc = failure.exception;
                }
                return failure.copy(exc);
            }

            /* renamed from: component1, reason: from getter */
            public final Exception getException() {
                return this.exception;
            }

            public final Failure copy(Exception exception) {
                m.checkNotNullParameter(exception, "exception");
                return new Failure(exception);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && m.areEqual(this.exception, ((Failure) other).exception);
                }
                return true;
            }

            public final Exception getException() {
                return this.exception;
            }

            public int hashCode() {
                Exception exc = this.exception;
                if (exc != null) {
                    return exc.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Failure(exception=");
                sbU.append(this.exception);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: RepresentativeColors.kt */
        public static final /* data */ class Success extends RepresentativeColorResult {
            private final int color;

            public Success(@ColorInt int i) {
                super(null);
                this.color = i;
            }

            public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = success.color;
                }
                return success.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            public final Success copy(@ColorInt int color) {
                return new Success(color);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && this.color == ((Success) other).color;
                }
                return true;
            }

            public final int getColor() {
                return this.color;
            }

            public int hashCode() {
                return this.color;
            }

            public String toString() {
                return a.B(a.U("Success(color="), this.color, ")");
            }
        }

        private RepresentativeColorResult() {
        }

        public /* synthetic */ RepresentativeColorResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RepresentativeColors.kt */
    @e(c = "com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2", f = "RepresentativeColors.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends k implements Function2<CoroutineScope, Continuation<? super RepresentativeColorResult>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Bitmap bitmap, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(this.$bitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RepresentativeColorResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
            return RepresentativeColors.access$getRepresentativeColor(RepresentativeColors.this, this.$bitmap);
        }
    }

    /* compiled from: RepresentativeColors.kt */
    @e(c = "com.discord.utilities.colors.RepresentativeColors$handleBitmap$1", f = "RepresentativeColors.kt", l = {59}, m = "invokeSuspend")
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$handleBitmap$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public final /* synthetic */ Object $id;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Object obj, Bitmap bitmap, String str, Continuation continuation) {
            super(2, continuation);
            this.$id = obj;
            this.$bitmap = bitmap;
            this.$url = str;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$id, this.$bitmap, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            int iAccess$getBLURPLE$cp;
            int iAccess$getBLURPLE$cp2;
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                if (RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).containsKey(this.$id)) {
                    return Unit.a;
                }
                if (this.$bitmap.isRecycled()) {
                    iAccess$getBLURPLE$cp = RepresentativeColors.access$getBLURPLE$cp();
                    RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).put(this.$id, b.boxInt(iAccess$getBLURPLE$cp));
                    RepresentativeColors.access$getRepresentativeColorsSubject$p(RepresentativeColors.this).onNext(RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this));
                    return Unit.a;
                }
                Bitmap bitmapCopy = this.$bitmap.copy(Bitmap.Config.ARGB_8888, false);
                RepresentativeColors representativeColors = RepresentativeColors.this;
                m.checkNotNullExpressionValue(bitmapCopy, "copiedBitmap");
                this.label = 1;
                obj = representativeColors.getRepresentativeColorAsync(bitmapCopy, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            RepresentativeColorResult representativeColorResult = (RepresentativeColorResult) obj;
            if (representativeColorResult instanceof RepresentativeColorResult.Success) {
                iAccess$getBLURPLE$cp2 = ((RepresentativeColorResult.Success) representativeColorResult).getColor();
            } else {
                if (!(representativeColorResult instanceof RepresentativeColorResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                }
                iAccess$getBLURPLE$cp2 = RepresentativeColors.access$getBLURPLE$cp();
            }
            if (representativeColorResult instanceof RepresentativeColorResult.Failure) {
                AppLog appLog = AppLog.g;
                Exception exception = ((RepresentativeColorResult.Failure) representativeColorResult).getException();
                Pair[] pairArr = new Pair[4];
                pairArr[0] = o.to(ModelAuditLogEntry.CHANGE_KEY_ID, String.valueOf(this.$id));
                pairArr[1] = o.to("bitmapWidth", String.valueOf(this.$bitmap.getWidth()));
                pairArr[2] = o.to("bitmapHeight", String.valueOf(this.$bitmap.getHeight()));
                String str = this.$url;
                if (str == null) {
                    str = "not provided";
                }
                pairArr[3] = o.to("url", str);
                appLog.e("Failed to get representative color for entity", exception, h0.mapOf(pairArr));
            }
            iAccess$getBLURPLE$cp = iAccess$getBLURPLE$cp2;
            RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).put(this.$id, b.boxInt(iAccess$getBLURPLE$cp));
            RepresentativeColors.access$getRepresentativeColorsSubject$p(RepresentativeColors.this).onNext(RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this));
            return Unit.a;
        }
    }

    /* compiled from: RepresentativeColors.kt */
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$observeRepresentativeColor$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<Map<T, ? extends Integer>, Integer> {
        public final /* synthetic */ Object $id;

        public AnonymousClass1(Object obj) {
            this.$id = obj;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Integer call(Object obj) {
            return call((Map) obj);
        }

        public final Integer call(Map<T, Integer> map) {
            return map.get(this.$id);
        }
    }

    public static final /* synthetic */ int access$getBLURPLE$cp() {
        return BLURPLE;
    }

    public static final /* synthetic */ RepresentativeColorResult access$getRepresentativeColor(RepresentativeColors representativeColors, Bitmap bitmap) {
        return representativeColors.getRepresentativeColor(bitmap);
    }

    public static final /* synthetic */ HashMap access$getRepresentativeColors$p(RepresentativeColors representativeColors) {
        return representativeColors.representativeColors;
    }

    public static final /* synthetic */ BehaviorSubject access$getRepresentativeColorsSubject$p(RepresentativeColors representativeColors) {
        return representativeColors.representativeColorsSubject;
    }

    private final int getColorDistance(int c1, int c2) {
        int i = ((c1 >> 16) & 255) - ((c2 >> 16) & 255);
        int i2 = ((c1 >> 8) & 255) - ((c2 >> 8) & 255);
        int i3 = (c1 & 255) - (c2 & 255);
        return Math.abs((i3 * i3) + (i2 * i2) + (i * i));
    }

    private final List<Integer> getPrimaryColorsForBitmap(Bitmap bitmap) {
        a.b bVar = b.a.g.a.a;
        m.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        List<d> list = new b.a.g.a(new b.a.g.b(iArr), 2, null).e;
        if (!list.isEmpty()) {
            return d0.t.m.listOf(Integer.valueOf(list.get(0).d));
        }
        throw new NoSwatchesFoundException();
    }

    private final RepresentativeColorResult getRepresentativeColor(Bitmap bitmap) {
        try {
            int alphaComponent = ColorUtils.setAlphaComponent(getPrimaryColorsForBitmap(bitmap).get(0).intValue(), 255);
            int i = Integer.MAX_VALUE;
            int width = bitmap.getWidth();
            int i2 = alphaComponent;
            for (int i3 = 0; i3 < width; i3++) {
                int height = bitmap.getHeight();
                for (int i4 = 0; i4 < height; i4++) {
                    int alphaComponent2 = ColorUtils.setAlphaComponent(bitmap.getPixel(i3, i4), 255);
                    int colorDistance = getColorDistance(alphaComponent, alphaComponent2);
                    if (colorDistance < i) {
                        i2 = alphaComponent2;
                        i = colorDistance;
                    }
                }
            }
            return new RepresentativeColorResult.Success(i2);
        } catch (Exception e) {
            return new RepresentativeColorResult.Failure(e);
        }
    }

    public static /* synthetic */ void handleBitmap$default(RepresentativeColors representativeColors, Object obj, Bitmap bitmap, String str, int i, Object obj2) {
        if ((i & 4) != 0) {
            str = null;
        }
        representativeColors.handleBitmap(obj, bitmap, str);
    }

    public final Object getRepresentativeColorAsync(Bitmap bitmap, Continuation<? super RepresentativeColorResult> continuation) {
        return f.C1(k0.a, new AnonymousClass2(bitmap, null), continuation);
    }

    public final void handleBitmap(T id2, Bitmap bitmap, String url) {
        m.checkNotNullParameter(bitmap, "bitmap");
        x0 x0Var = x0.j;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        f.H0(x0Var, n.f3830b, null, new AnonymousClass1(id2, bitmap, url, null), 2, null);
    }

    public final Observable<Integer> observeRepresentativeColor(T id2) {
        Observable<Integer> observableR = this.representativeColorsSubject.G(new AnonymousClass1(id2)).r();
        m.checkNotNullExpressionValue(observableR, "representativeColorsSubj…  .distinctUntilChanged()");
        return observableR;
    }
}
