package p007b.p076b.p077a.p079d;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.lytefast.flexinput.fragment.FilesFragment;
import p007b.p076b.p077a.p079d.AddContentPagerAdapter4;

/* compiled from: AddContentPagerAdapter.kt */
/* renamed from: b.b.a.d.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AddContentPagerAdapter2 extends AddContentPagerAdapter4.a {
    public AddContentPagerAdapter2(Context context, int i, int i2) {
        super(i, i2);
    }

    @Override // p007b.p076b.p077a.p079d.AddContentPagerAdapter4.a
    public Fragment createFragment() {
        return new FilesFragment();
    }
}
