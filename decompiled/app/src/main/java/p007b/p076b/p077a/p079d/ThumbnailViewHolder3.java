package p007b.p076b.p077a.p079d;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Size;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p076b.p077a.p079d.ThumbnailViewHolder;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ThumbnailViewHolder.kt */
@DebugMetadata(m10084c = "com.lytefast.flexinput.adapters.ThumbnailViewHolder$ThumbnailBitmapGenerator$getThumbnailQ$2", m10085f = "ThumbnailViewHolder.kt", m10086l = {}, m10087m = "invokeSuspend")
/* renamed from: b.b.a.d.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class ThumbnailViewHolder3 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ ContentResolver $contentResolver;
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ ThumbnailViewHolder.b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailViewHolder3(ThumbnailViewHolder.b bVar, ContentResolver contentResolver, Uri uri, Continuation continuation) {
        super(2, continuation);
        this.this$0 = bVar;
        this.$contentResolver = contentResolver;
        this.$uri = uri;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new ThumbnailViewHolder3(this.this$0, this.$contentResolver, this.$uri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        Continuation<? super Bitmap> continuation2 = continuation;
        Intrinsics3.checkNotNullParameter(continuation2, "completion");
        return new ThumbnailViewHolder3(this.this$0, this.$contentResolver, this.$uri, continuation2).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Intrinsics2.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result3.throwOnFailure(obj);
        try {
            return this.$contentResolver.loadThumbnail(this.$uri, new Size(ThumbnailViewHolder.f2159j, ThumbnailViewHolder.f2160k), this.this$0.f2166b);
        } catch (Exception unused) {
            return null;
        }
    }
}
