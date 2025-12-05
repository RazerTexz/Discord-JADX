package androidx.core.graphics;

import android.graphics.Canvas;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.InlineMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Picture.kt */
/* renamed from: androidx.core.graphics.PictureKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Picture {
    public static final android.graphics.Picture record(android.graphics.Picture picture, int i, int i2, Function1<? super Canvas, Unit> function1) {
        Intrinsics3.checkNotNullParameter(picture, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i, i2);
        Intrinsics3.checkNotNullExpressionValue(canvasBeginRecording, "beginRecording(width, height)");
        try {
            function1.invoke(canvasBeginRecording);
            return picture;
        } finally {
            InlineMarker.finallyStart(1);
            picture.endRecording();
            InlineMarker.finallyEnd(1);
        }
    }
}
