package p007b.p452o.p453a.p468s;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.o.a.s.a, reason: use source file name */
/* JADX INFO: compiled from: AutoFocusMarker.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AutoFocusMarker {
    /* JADX INFO: renamed from: a */
    void m7405a(@NonNull AutoFocusTrigger autoFocusTrigger, @NonNull PointF pointF);

    @Nullable
    /* JADX INFO: renamed from: b */
    View m7406b(@NonNull Context context, @NonNull ViewGroup viewGroup);

    /* JADX INFO: renamed from: c */
    void m7407c(@NonNull AutoFocusTrigger autoFocusTrigger, boolean z2, @NonNull PointF pointF);
}
