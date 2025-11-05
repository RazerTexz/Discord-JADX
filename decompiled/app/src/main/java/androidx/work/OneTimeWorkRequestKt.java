package androidx.work;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import d0.e0.c;
import d0.z.a;
import d0.z.d.m;

/* compiled from: OneTimeWorkRequest.kt */
/* loaded from: classes.dex */
public final class OneTimeWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        m.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest.Builder(ListenableWorker.class);
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull c<? extends InputMerger> cVar) {
        m.checkParameterIsNotNull(builder, "$this$setInputMerger");
        m.checkParameterIsNotNull(cVar, "inputMerger");
        OneTimeWorkRequest.Builder inputMerger = builder.setInputMerger(a.getJavaClass(cVar));
        m.checkExpressionValueIsNotNull(inputMerger, "setInputMerger(inputMerger.java)");
        return inputMerger;
    }
}
