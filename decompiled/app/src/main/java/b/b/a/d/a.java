package b.b.a.d;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.b.a.d.d;
import com.lytefast.flexinput.fragment.MediaFragment;

/* compiled from: AddContentPagerAdapter.kt */
/* loaded from: classes3.dex */
public final class a extends d.a {
    public a(Context context, int i, int i2) {
        super(i, i2);
    }

    @Override // b.b.a.d.d.a
    public Fragment createFragment() {
        return new MediaFragment();
    }
}
