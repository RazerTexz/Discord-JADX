package com.discord.widgets.nux;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetNavigationHelpBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetNavigationHelp.kt */
/* loaded from: classes2.dex */
public final class WidgetNavigationHelp extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNavigationHelp.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNavigationHelpBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetNavigationHelp.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            AnalyticsTracker.openModal$default("Help Nav", "Guild List", null, 4, null);
            new WidgetNavigationHelp().show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    public static final class NuxChannelsPageFragment extends AppFragment {
        public NuxChannelsPageFragment() {
            super(R.layout.widget_navigation_help_nux_channels);
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    public static final class NuxDmsPageFragment extends AppFragment {
        public NuxDmsPageFragment() {
            super(R.layout.widget_navigation_help_nux_dms);
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    public static final class NuxGuildsPageFragment extends AppFragment {
        public NuxGuildsPageFragment() {
            super(R.layout.widget_navigation_help_nux_guilds);
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    public static final class NuxPagerAdapter extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NuxPagerAdapter(Fragment fragment) {
            super(fragment);
            m.checkNotNullParameter(fragment, "fragment");
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            if (position == 0) {
                return new NuxGuildsPageFragment();
            }
            if (position == 1) {
                return new NuxChannelsPageFragment();
            }
            if (position == 2) {
                return new NuxDmsPageFragment();
            }
            throw new IllegalStateException(a.q("unknown nux page: ", position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return 3;
        }
    }

    /* compiled from: WidgetNavigationHelp.kt */
    /* renamed from: com.discord.widgets.nux.WidgetNavigationHelp$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNavigationHelp.this.dismissAllowingStateLoss();
        }
    }

    public WidgetNavigationHelp() {
        super(R.layout.widget_navigation_help);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNavigationHelp$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNavigationHelpBinding getBinding() {
        return (WidgetNavigationHelpBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setDimAmount(0.9f);
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(53);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().d.setPageTransformer(new MarginPageTransformer(DimenUtils.dpToPixels(8)));
        ViewPager2 viewPager2 = getBinding().d;
        m.checkNotNullExpressionValue(viewPager2, "binding.navigationHelpNuxPager");
        viewPager2.setAdapter(new NuxPagerAdapter(this));
        TabLayout tabLayout = getBinding().c;
        m.checkNotNullExpressionValue(tabLayout, "binding.navigationHelpIndicators");
        ViewPager2 viewPager22 = getBinding().d;
        m.checkNotNullExpressionValue(viewPager22, "binding.navigationHelpNuxPager");
        ViewPager2ExtensionsKt.setUpWithViewPager2$default(tabLayout, viewPager22, null, 2, null);
        getBinding().f2499b.setOnClickListener(new AnonymousClass1());
    }
}
