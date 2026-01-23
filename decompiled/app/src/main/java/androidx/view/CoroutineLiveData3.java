package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.coroutines.Continuation;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.DebugMetadata;

/* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveData$clearSource$1, reason: use source file name */
/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
@DebugMetadata(m10084c = "androidx.lifecycle.CoroutineLiveData", m10085f = "CoroutineLiveData.kt", m10086l = {234}, m10087m = "clearSource$lifecycle_livedata_ktx_release")
public final class CoroutineLiveData3 extends ContinuationImpl3 {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CoroutineLiveData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData3(CoroutineLiveData coroutineLiveData, Continuation continuation) {
        super(continuation);
        this.this$0 = coroutineLiveData;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearSource$lifecycle_livedata_ktx_release(this);
    }
}
