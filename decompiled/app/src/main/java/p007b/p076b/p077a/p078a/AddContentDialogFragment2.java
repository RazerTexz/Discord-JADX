package p007b.p076b.p077a.p078a;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.b.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: AddContentDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AddContentDialogFragment2 implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AddContentDialogFragment f2129a;

    public AddContentDialogFragment2(AddContentDialogFragment addContentDialogFragment) {
        this.f2129a = addContentDialogFragment;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        FlexInputViewModel flexInputViewModel;
        Intrinsics3.checkNotNullParameter(tab, "tab");
        int position = tab.getPosition();
        if (position != 3) {
            ViewPager viewPager = this.f2129a.contentPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(position);
                return;
            }
            return;
        }
        this.f2129a.m395h(false);
        Fragment parentFragment = this.f2129a.getParentFragment();
        if (!(parentFragment instanceof FlexInputFragment) || (flexInputViewModel = ((FlexInputFragment) parentFragment).viewModel) == null) {
            return;
        }
        flexInputViewModel.onCreateThreadSelected();
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        Intrinsics3.checkNotNullParameter(tab, "tab");
    }
}
