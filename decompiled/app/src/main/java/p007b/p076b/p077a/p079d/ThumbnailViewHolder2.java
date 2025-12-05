package p007b.p076b.p077a.p079d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p076b.p077a.p079d.ThumbnailViewHolder;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;

/* compiled from: ThumbnailViewHolder.kt */
@DebugMetadata(m10084c = "com.lytefast.flexinput.adapters.ThumbnailViewHolder$ThumbnailBitmapGenerator$generate$1", m10085f = "ThumbnailViewHolder.kt", m10086l = {102}, m10087m = "invokeSuspend")
/* renamed from: b.b.a.d.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class ThumbnailViewHolder2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1 $onGenerate;
    public final /* synthetic */ Uri $uri;
    public Object L$0;
    public int label;
    public final /* synthetic */ ThumbnailViewHolder.b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailViewHolder2(ThumbnailViewHolder.b bVar, Uri uri, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = bVar;
        this.$uri = uri;
        this.$onGenerate = function1;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new ThumbnailViewHolder2(this.this$0, this.$uri, this.$onGenerate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics3.checkNotNullParameter(continuation2, "completion");
        return new ThumbnailViewHolder2(this.this$0, this.$uri, this.$onGenerate, continuation2).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ThumbnailViewHolder.b bVar;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            this.this$0.f2166b = new CancellationSignal();
            ThumbnailViewHolder.b bVar2 = this.this$0;
            ContentResolver contentResolver = bVar2.f2168d;
            Uri uri = this.$uri;
            this.L$0 = bVar2;
            this.label = 1;
            Objects.requireNonNull(bVar2);
            Object objM4197C1 = C3404f.m4197C1(Dispatchers.f27867b, new ThumbnailViewHolder3(bVar2, contentResolver, uri, null), this);
            if (objM4197C1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            bVar = bVar2;
            obj = objM4197C1;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bVar = (ThumbnailViewHolder.b) this.L$0;
            Result3.throwOnFailure(obj);
        }
        bVar.f2167c = (Bitmap) obj;
        this.$onGenerate.invoke(this.this$0.f2167c);
        return Unit.f27425a;
    }
}
