package androidx.work;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import p507d0.p513e0.KClass;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: androidx.work.OneTimeWorkRequestKt, reason: use source file name */
/* JADX INFO: compiled from: OneTimeWorkRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OneTimeWorkRequest2 {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest.Builder(ListenableWorker.class);
    }

    public static final OneTimeWorkRequest.Builder setInputMerger(OneTimeWorkRequest.Builder builder, @NonNull KClass<? extends InputMerger> kClass) {
        Intrinsics3.checkParameterIsNotNull(builder, "$this$setInputMerger");
        Intrinsics3.checkParameterIsNotNull(kClass, "inputMerger");
        OneTimeWorkRequest.Builder inputMerger = builder.setInputMerger(JvmClassMapping.getJavaClass(kClass));
        Intrinsics3.checkExpressionValueIsNotNull(inputMerger, "setInputMerger(inputMerger.java)");
        return inputMerger;
    }
}
