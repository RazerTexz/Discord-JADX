package com.discord.utilities.apng;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p443l.p444a.ApngDrawable;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p591y.Closeable;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.CoroutineScope2;
import p659s.p660a.Dispatchers;
import p659s.p660a.MainCoroutineDispatcher;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: compiled from: ApngUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApngUtils {
    public static final ApngUtils INSTANCE = new ApngUtils();

    /* JADX INFO: renamed from: com.discord.utilities.apng.ApngUtils$renderApngFromFile$3 */
    /* JADX INFO: compiled from: ApngUtils.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.apng.ApngUtils$renderApngFromFile$3", m10085f = "ApngUtils.kt", m10086l = {31}, m10087m = "invokeSuspend")
    public static final class C66873 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $autoPlay;
        public final /* synthetic */ File $file;
        public final /* synthetic */ Ref$ObjectRef $imageViewRef;
        public final /* synthetic */ Integer $maxHeight;
        public final /* synthetic */ Integer $maxWidth;
        public int label;

        /* JADX INFO: renamed from: com.discord.utilities.apng.ApngUtils$renderApngFromFile$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: ApngUtils.kt */
        @DebugMetadata(m10084c = "com.discord.utilities.apng.ApngUtils$renderApngFromFile$3$1", m10085f = "ApngUtils.kt", m10086l = {}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Ref$ObjectRef $drawable;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
                super(2, continuation);
                this.$drawable = ref$ObjectRef;
            }

            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return C66873.this.new AnonymousClass1(this.$drawable, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Intrinsics2.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
                ImageView imageView = (ImageView) ((WeakReference) C66873.this.$imageViewRef.element).get();
                if (imageView == null) {
                    return Unit.f27425a;
                }
                Intrinsics3.checkNotNullExpressionValue(imageView, "imageViewRef.get() ?: return@withContext");
                imageView.setImageDrawable((ApngDrawable) this.$drawable.element);
                if (C66873.this.$autoPlay) {
                    ApngUtils.INSTANCE.playApngAnimation((ApngDrawable) this.$drawable.element);
                }
                return Unit.f27425a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66873(File file, Integer num, Integer num2, Ref$ObjectRef ref$ObjectRef, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.$file = file;
            this.$maxHeight = num;
            this.$maxWidth = num2;
            this.$imageViewRef = ref$ObjectRef;
            this.$autoPlay = z2;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C66873(this.$file, this.$maxHeight, this.$maxWidth, this.$imageViewRef, this.$autoPlay, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66873) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [T, b.l.a.a] */
        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    File file = this.$file;
                    Integer num = this.$maxHeight;
                    Integer num2 = this.$maxWidth;
                    Intrinsics3.checkNotNullParameter(file, "file");
                    InputStream fileInputStream = new FileInputStream(file);
                    BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
                    try {
                        ?? M7121a = ApngDrawable.m7121a(bufferedInputStream, num2, num);
                        Closeable.closeFinally(bufferedInputStream, null);
                        ref$ObjectRef.element = M7121a;
                        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
                        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatchers.f27700b;
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$ObjectRef, null);
                        this.label = 1;
                        if (C3404f.m4197C1(mainCoroutineDispatcher, anonymousClass1, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } finally {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.f27425a;
        }
    }

    private ApngUtils() {
    }

    public static /* synthetic */ Job renderApngFromFile$default(ApngUtils apngUtils, File file, ImageView imageView, Integer num, Integer num2, boolean z2, int i, Object obj) {
        return apngUtils.renderApngFromFile(file, imageView, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z2);
    }

    public final void pauseApngAnimation(Drawable drawable) {
        if (drawable instanceof ApngDrawable) {
            ((ApngDrawable) drawable).stop();
        }
    }

    public final void playApngAnimation(Drawable drawable) {
        if (drawable instanceof ApngDrawable) {
            ((ApngDrawable) drawable).start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.ref.WeakReference] */
    public final Job renderApngFromFile(File file, ImageView imageView, Integer maxWidth, Integer maxHeight, boolean autoPlay) {
        Intrinsics3.checkNotNullParameter(file, "file");
        Intrinsics3.checkNotNullParameter(imageView, "imageView");
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new WeakReference(imageView);
        if (maxHeight != null) {
            int iIntValue = maxHeight.intValue();
            ImageView imageView2 = (ImageView) ((WeakReference) ref$ObjectRef.element).get();
            if (imageView2 != null) {
                imageView2.setMaxHeight(iIntValue);
            }
        }
        if (maxWidth != null) {
            int iIntValue2 = maxWidth.intValue();
            ImageView imageView3 = (ImageView) ((WeakReference) ref$ObjectRef.element).get();
            if (imageView3 != null) {
                imageView3.setMaxWidth(iIntValue2);
            }
        }
        return C3404f.m4211H0(CoroutineScope2.f27919j, Dispatchers.f27867b, null, new C66873(file, maxHeight, maxWidth, ref$ObjectRef, autoPlay, null), 2, null);
    }
}
