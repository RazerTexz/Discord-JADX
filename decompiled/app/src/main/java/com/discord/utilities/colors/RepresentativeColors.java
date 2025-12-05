package com.discord.utilities.colors;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p023g.ColorCutQuantizer;
import p007b.p008a.p023g.ColorHistogram;
import p007b.p008a.p023g.Swatch;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.Tuples;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Maps6;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.boxing;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p659s.p660a.CoroutineScope2;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: RepresentativeColors.kt */
/* loaded from: classes2.dex */
public final class RepresentativeColors<T> {
    private final HashMap<T, Integer> representativeColors = new HashMap<>();
    private final BehaviorSubject<Map<T, Integer>> representativeColorsSubject = BehaviorSubject.m11129k0();
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
                Intrinsics3.checkNotNullParameter(exc, "exception");
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
                Intrinsics3.checkNotNullParameter(exception, "exception");
                return new Failure(exception);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && Intrinsics3.areEqual(this.exception, ((Failure) other).exception);
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
                StringBuilder sbM833U = outline.m833U("Failure(exception=");
                sbM833U.append(this.exception);
                sbM833U.append(")");
                return sbM833U.toString();
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
                return outline.m814B(outline.m833U("Success(color="), this.color, ")");
            }
        }

        private RepresentativeColorResult() {
        }

        public /* synthetic */ RepresentativeColorResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RepresentativeColors.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2", m10085f = "RepresentativeColors.kt", m10086l = {}, m10087m = "invokeSuspend")
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$getRepresentativeColorAsync$2 */
    public static final class C67342 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super RepresentativeColorResult>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67342(Bitmap bitmap, Continuation continuation) {
            super(2, continuation);
            this.$bitmap = bitmap;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C67342(this.$bitmap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RepresentativeColorResult> continuation) {
            return ((C67342) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return RepresentativeColors.access$getRepresentativeColor(RepresentativeColors.this, this.$bitmap);
        }
    }

    /* compiled from: RepresentativeColors.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.colors.RepresentativeColors$handleBitmap$1", m10085f = "RepresentativeColors.kt", m10086l = {59}, m10087m = "invokeSuspend")
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$handleBitmap$1 */
    public static final class C67351 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Bitmap $bitmap;
        public final /* synthetic */ Object $id;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67351(Object obj, Bitmap bitmap, String str, Continuation continuation) {
            super(2, continuation);
            this.$id = obj;
            this.$bitmap = bitmap;
            this.$url = str;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C67351(this.$id, this.$bitmap, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67351) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int iAccess$getBLURPLE$cp;
            int iAccess$getBLURPLE$cp2;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                if (RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).containsKey(this.$id)) {
                    return Unit.f27425a;
                }
                if (this.$bitmap.isRecycled()) {
                    iAccess$getBLURPLE$cp = RepresentativeColors.access$getBLURPLE$cp();
                    RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).put(this.$id, boxing.boxInt(iAccess$getBLURPLE$cp));
                    RepresentativeColors.access$getRepresentativeColorsSubject$p(RepresentativeColors.this).onNext(RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this));
                    return Unit.f27425a;
                }
                Bitmap bitmapCopy = this.$bitmap.copy(Bitmap.Config.ARGB_8888, false);
                RepresentativeColors representativeColors = RepresentativeColors.this;
                Intrinsics3.checkNotNullExpressionValue(bitmapCopy, "copiedBitmap");
                this.label = 1;
                obj = representativeColors.getRepresentativeColorAsync(bitmapCopy, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
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
                AppLog appLog = AppLog.f14950g;
                Exception exception = ((RepresentativeColorResult.Failure) representativeColorResult).getException();
                Tuples2[] tuples2Arr = new Tuples2[4];
                tuples2Arr[0] = Tuples.m10073to(ModelAuditLogEntry.CHANGE_KEY_ID, String.valueOf(this.$id));
                tuples2Arr[1] = Tuples.m10073to("bitmapWidth", String.valueOf(this.$bitmap.getWidth()));
                tuples2Arr[2] = Tuples.m10073to("bitmapHeight", String.valueOf(this.$bitmap.getHeight()));
                String str = this.$url;
                if (str == null) {
                    str = "not provided";
                }
                tuples2Arr[3] = Tuples.m10073to("url", str);
                appLog.mo8364e("Failed to get representative color for entity", exception, Maps6.mapOf(tuples2Arr));
            }
            iAccess$getBLURPLE$cp = iAccess$getBLURPLE$cp2;
            RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this).put(this.$id, boxing.boxInt(iAccess$getBLURPLE$cp));
            RepresentativeColors.access$getRepresentativeColorsSubject$p(RepresentativeColors.this).onNext(RepresentativeColors.access$getRepresentativeColors$p(RepresentativeColors.this));
            return Unit.f27425a;
        }
    }

    /* compiled from: RepresentativeColors.kt */
    /* renamed from: com.discord.utilities.colors.RepresentativeColors$observeRepresentativeColor$1 */
    public static final class C67361<T, R> implements Func1<Map<T, ? extends Integer>, Integer> {
        public final /* synthetic */ Object $id;

        public C67361(Object obj) {
            this.$id = obj;
        }

        @Override // p637j0.p641k.Func1
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
        ColorCutQuantizer.b bVar = ColorCutQuantizer.f626a;
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        List<Swatch> list = new ColorCutQuantizer(new ColorHistogram(iArr), 2, null).f630e;
        if (!list.isEmpty()) {
            return CollectionsJVM.listOf(Integer.valueOf(list.get(0).f648d));
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
        return C3404f.m4197C1(Dispatchers.f27866a, new C67342(bitmap, null), continuation);
    }

    public final void handleBitmap(T id2, Bitmap bitmap, String url) {
        Intrinsics3.checkNotNullParameter(bitmap, "bitmap");
        CoroutineScope2 coroutineScope2 = CoroutineScope2.f27919j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        C3404f.m4211H0(coroutineScope2, MainDispatchers.f27700b, null, new C67351(id2, bitmap, url, null), 2, null);
    }

    public final Observable<Integer> observeRepresentativeColor(T id2) {
        Observable<Integer> observableM11112r = this.representativeColorsSubject.m11083G(new C67361(id2)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "representativeColorsSubj…  .distinctUntilChanged()");
        return observableM11112r;
    }
}
