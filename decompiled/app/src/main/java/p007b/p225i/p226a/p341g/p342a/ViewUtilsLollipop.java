package p007b.p225i.p226a.p341g.p342a;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import com.google.android.material.C10817R;

/* compiled from: ViewUtilsLollipop.java */
@RequiresApi(21)
/* renamed from: b.i.a.g.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public class ViewUtilsLollipop {

    /* renamed from: a */
    public static final int[] f11537a = {R.attr.stateListAnimator};

    /* renamed from: a */
    public static void m6035a(@NonNull View view, float f) throws Resources.NotFoundException {
        int integer = view.getResources().getInteger(C10817R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, C10817R.attr.state_liftable, -C10817R.attr.state_lifted}, ObjectAnimator.ofFloat(view, Key.ELEVATION, 0.0f).setDuration(j));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, Key.ELEVATION, f).setDuration(j));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, Key.ELEVATION, 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
