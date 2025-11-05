package b.a.a.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import b.a.i.u5;
import b.a.i.w0;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import d0.t.n;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* loaded from: classes.dex */
public final class c extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(c.class, "binding", "getBinding()Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public e pagerAdapter;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                ((c) this.k).dismiss();
            } else if (i == 1) {
                c.g((c) this.k);
            } else {
                if (i != 2) {
                    throw null;
                }
                c.g((c) this.k);
            }
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.c$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static void a(Companion companion, FragmentManager fragmentManager, int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3, int i2) {
            if ((i2 & 4) != 0) {
                str = null;
            }
            if ((i2 & 8) != 0) {
                str2 = null;
            }
            if ((i2 & 16) != 0) {
                str3 = null;
            }
            if ((i2 & 32) != 0) {
                str4 = null;
            }
            if ((i2 & 64) != 0) {
                str5 = null;
            }
            if ((i2 & 128) != 0) {
                str6 = null;
            }
            if ((i2 & 256) != 0) {
                z2 = true;
            }
            if ((i2 & 512) != 0) {
                z3 = true;
            }
            Objects.requireNonNull(companion);
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putInt("extra_page_number", i);
            if (str != null) {
                bundle.putString("extra_header_string", str);
            }
            if (str2 != null) {
                bundle.putString("extra_body_text", str2);
            }
            bundle.putString("extra_page_name", str3);
            bundle.putString("extra_section_name", str4);
            bundle.putString("extra_object_name", str5);
            bundle.putString("extra_object_type", str6);
            bundle.putBoolean("extra_show_other_pages", z2);
            bundle.putBoolean("extra_show_learn_more", z3);
            cVar.setArguments(bundle);
            cVar.show(fragmentManager, c.class.getName());
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.c$c, reason: collision with other inner class name */
    public static final class C0019c {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f45b;
        public CharSequence c;

        public C0019c(@DrawableRes int i, CharSequence charSequence, CharSequence charSequence2) {
            m.checkNotNullParameter(charSequence, "headerText");
            m.checkNotNullParameter(charSequence2, "bodyText");
            this.a = i;
            this.f45b = charSequence;
            this.c = charSequence2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0019c)) {
                return false;
            }
            C0019c c0019c = (C0019c) obj;
            return this.a == c0019c.a && m.areEqual(this.f45b, c0019c.f45b) && m.areEqual(this.c, c0019c.c);
        }

        public int hashCode() {
            int i = this.a * 31;
            CharSequence charSequence = this.f45b;
            int iHashCode = (i + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            CharSequence charSequence2 = this.c;
            return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("UpsellData(imageResId=");
            sbU.append(this.a);
            sbU.append(", headerText=");
            sbU.append(this.f45b);
            sbU.append(", bodyText=");
            return b.d.b.a.a.E(sbU, this.c, ")");
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final class d extends AppFragment {
        public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(d.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0)};

        /* renamed from: k, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: l, reason: from kotlin metadata */
        public final FragmentViewBindingDelegate binding;

        /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
        /* renamed from: b.a.a.b.c$d$a, reason: from kotlin metadata */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
        public static final /* synthetic */ class b extends k implements Function1<View, u5> {
            public static final b j = new b();

            public b() {
                super(1, u5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public u5 invoke(View view) {
                View view2 = view;
                m.checkNotNullParameter(view2, "p1");
                int i = R.id.premium_upsell_body;
                TextView textView = (TextView) view2.findViewById(R.id.premium_upsell_body);
                if (textView != null) {
                    i = R.id.premium_upsell_header;
                    TextView textView2 = (TextView) view2.findViewById(R.id.premium_upsell_header);
                    if (textView2 != null) {
                        i = R.id.premium_upsell_img;
                        ImageView imageView = (ImageView) view2.findViewById(R.id.premium_upsell_img);
                        if (imageView != null) {
                            return new u5((LinearLayout) view2, textView, textView2, imageView);
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
            }
        }

        public d() {
            super(R.layout.widget_premium_upsell);
            this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
        }

        public final u5 g() {
            return (u5) this.binding.getValue((Fragment) this, j[0]);
        }

        @Override // com.discord.app.AppFragment
        public void onViewBoundOrOnResume() {
            String string;
            super.onViewBoundOrOnResume();
            ImageView imageView = g().d;
            Bundle arguments = getArguments();
            imageView.setImageResource(arguments != null ? arguments.getInt("extra_image_id") : 0);
            TextView textView = g().c;
            m.checkNotNullExpressionValue(textView, "binding.premiumUpsellHeader");
            Bundle arguments2 = getArguments();
            textView.setText(arguments2 != null ? arguments2.getString("extra_header_string") : null);
            TextView textView2 = g().f212b;
            m.checkNotNullExpressionValue(textView2, "binding.premiumUpsellBody");
            Bundle arguments3 = getArguments();
            textView2.setText((arguments3 == null || (string = arguments3.getString("extra_body_text")) == null) ? "" : b.a.k.b.l(string, new Object[0], null, 2));
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final class e extends FragmentStateAdapter {
        public final List<C0019c> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment, List<C0019c> list) {
            super(fragment);
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(list, "pages");
            this.a = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            C0019c c0019c = this.a.get(i);
            d.Companion companion = d.INSTANCE;
            int i2 = c0019c.a;
            CharSequence charSequence = c0019c.f45b;
            CharSequence charSequence2 = c0019c.c;
            Objects.requireNonNull(companion);
            m.checkNotNullParameter(charSequence, "headerText");
            m.checkNotNullParameter(charSequence2, "bodyText");
            Bundle bundle = new Bundle();
            bundle.putInt("extra_image_id", i2);
            bundle.putString("extra_header_string", charSequence.toString());
            bundle.putString("extra_body_text", charSequence2.toString());
            d dVar = new d();
            dVar.setArguments(bundle);
            return dVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getPageSize() {
            return this.a.size();
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    public static final /* synthetic */ class f extends k implements Function1<View, w0> {
        public static final f j = new f();

        public f() {
            super(1, w0.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public w0 invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.premium_upsell_button_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.premium_upsell_button_container);
            if (linearLayout != null) {
                i = R.id.premium_upsell_close;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.premium_upsell_close);
                if (materialButton != null) {
                    i = R.id.premium_upsell_divider;
                    View viewFindViewById = view2.findViewById(R.id.premium_upsell_divider);
                    if (viewFindViewById != null) {
                        i = R.id.premium_upsell_dots;
                        TabLayout tabLayout = (TabLayout) view2.findViewById(R.id.premium_upsell_dots);
                        if (tabLayout != null) {
                            i = R.id.premium_upsell_get_premium;
                            MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.premium_upsell_get_premium);
                            if (materialButton2 != null) {
                                i = R.id.premium_upsell_learn_more;
                                MaterialButton materialButton3 = (MaterialButton) view2.findViewById(R.id.premium_upsell_learn_more);
                                if (materialButton3 != null) {
                                    i = R.id.premium_upsell_viewpager;
                                    ViewPager2 viewPager2 = (ViewPager2) view2.findViewById(R.id.premium_upsell_viewpager);
                                    if (viewPager2 != null) {
                                        return new w0((RelativeLayout) view2, linearLayout, materialButton, viewFindViewById, tabLayout, materialButton2, materialButton3, viewPager2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    public c() {
        super(R.layout.multi_value_prop_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, f.j, null, 2, null);
    }

    public static final void g(c cVar) {
        Bundle arguments = cVar.getArguments();
        String string = arguments != null ? arguments.getString("extra_page_name") : null;
        Bundle arguments2 = cVar.getArguments();
        String string2 = arguments2 != null ? arguments2.getString("extra_section_name") : null;
        Bundle arguments3 = cVar.getArguments();
        String string3 = arguments3 != null ? arguments3.getString("extra_object_name") : null;
        Bundle arguments4 = cVar.getArguments();
        AnalyticsTracker.INSTANCE.premiumSettingsOpened(new Traits.Location(string, string2, string3, arguments4 != null ? arguments4.getString("extra_object_type") : null, null, 16, null));
        WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
        Context contextRequireContext = cVar.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
        cVar.dismiss();
    }

    public final w0 h() {
        return (w0) this.binding.getValue((Fragment) this, j[0]);
    }

    public final boolean i() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_learn_more");
    }

    public final boolean j() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_other_pages");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        AppDialog.hideKeyboard$default(this, null, 1, null);
        String string3 = getString(R.string.premium_upsell_tag_passive_mobile);
        m.checkNotNullExpressionValue(string3, "getString(R.string.premi…psell_tag_passive_mobile)");
        String string4 = getString(R.string.premium_upsell_tag_description_mobile);
        m.checkNotNullExpressionValue(string4, "getString(R.string.premi…l_tag_description_mobile)");
        String string5 = getString(R.string.premium_upsell_emoji_passive_mobile);
        m.checkNotNullExpressionValue(string5, "getString(R.string.premi…ell_emoji_passive_mobile)");
        String string6 = getString(R.string.premium_upsell_emoji_description_mobile);
        m.checkNotNullExpressionValue(string6, "getString(R.string.premi…emoji_description_mobile)");
        String string7 = getString(R.string.premium_upsell_animated_emojis_passive_mobile);
        m.checkNotNullExpressionValue(string7, "getString(R.string.premi…ed_emojis_passive_mobile)");
        String string8 = getString(R.string.premium_upsell_animated_emojis_description_mobile);
        m.checkNotNullExpressionValue(string8, "getString(R.string.premi…mojis_description_mobile)");
        CharSequence charSequenceK = b.a.k.b.k(this, R.string.premium_upsell_upload_passive_mobile, new Object[0], null, 4);
        Object[] objArr = {b.a.k.b.k(this, R.string.file_upload_limit_standard, new Object[0], null, 4), b.a.k.b.k(this, R.string.file_upload_limit_premium_tier_2, new Object[0], null, 4)};
        String string9 = getString(R.string.premium_upsell_animated_avatar_passive_mobile);
        m.checkNotNullExpressionValue(string9, "getString(R.string.premi…ed_avatar_passive_mobile)");
        String string10 = getString(R.string.premium_upsell_animated_avatar_description_mobile);
        m.checkNotNullExpressionValue(string10, "getString(R.string.premi…vatar_description_mobile)");
        String string11 = getString(R.string.premium_upsell_badge_passive_mobile);
        m.checkNotNullExpressionValue(string11, "getString(R.string.premi…ell_badge_passive_mobile)");
        String string12 = getString(R.string.premium_upsell_badge_description_mobile);
        m.checkNotNullExpressionValue(string12, "getString(R.string.premi…badge_description_mobile)");
        List listListOf = n.listOf((Object[]) new C0019c[]{new C0019c(R.drawable.img_tag_upsell, string3, string4), new C0019c(R.drawable.img_global_emoji_upsell, string5, string6), new C0019c(R.drawable.img_animated_emoji_upsell, string7, string8), new C0019c(R.drawable.img_upload_upsell, charSequenceK, b.a.k.b.k(this, R.string.premium_upsell_upload_description_mobile, objArr, null, 4)), new C0019c(R.drawable.img_avatar_upsell, string9, string10), new C0019c(R.drawable.img_badge_upsell, string11, string12)});
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("extra_page_number") : 0;
        Bundle arguments2 = getArguments();
        String str = "";
        if (arguments2 != null && arguments2.containsKey("extra_header_string")) {
            C0019c c0019c = (C0019c) listListOf.get(i);
            Bundle arguments3 = getArguments();
            if (arguments3 == null || (string2 = arguments3.getString("extra_header_string")) == null) {
                string2 = "";
            }
            Objects.requireNonNull(c0019c);
            m.checkNotNullParameter(string2, "<set-?>");
            c0019c.f45b = string2;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null && arguments4.containsKey("extra_body_text")) {
            C0019c c0019c2 = (C0019c) listListOf.get(i);
            Bundle arguments5 = getArguments();
            if (arguments5 != null && (string = arguments5.getString("extra_body_text")) != null) {
                str = string;
            }
            Objects.requireNonNull(c0019c2);
            m.checkNotNullParameter(str, "<set-?>");
            c0019c2.c = str;
        }
        C0019c c0019c3 = (C0019c) listListOf.get(i);
        List listMutableListOf = n.mutableListOf(c0019c3);
        if (j()) {
            listMutableListOf.addAll(u.minus(listListOf, c0019c3));
        }
        this.pagerAdapter = new e(this, listMutableListOf);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewPager2 viewPager2 = h().f;
        m.checkNotNullExpressionValue(viewPager2, "binding.premiumUpsellViewpager");
        e eVar = this.pagerAdapter;
        if (eVar == null) {
            m.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        viewPager2.setAdapter(eVar);
        TabLayout tabLayout = h().c;
        m.checkNotNullExpressionValue(tabLayout, "binding.premiumUpsellDots");
        tabLayout.setVisibility(j() ? 0 : 8);
        TabLayout tabLayout2 = h().c;
        m.checkNotNullExpressionValue(tabLayout2, "binding.premiumUpsellDots");
        ViewPager2 viewPager22 = h().f;
        m.checkNotNullExpressionValue(viewPager22, "binding.premiumUpsellViewpager");
        ViewPager2ExtensionsKt.setUpWithViewPager2$default(tabLayout2, viewPager22, null, 2, null);
        h().f221b.setOnClickListener(new a(0, this));
        MaterialButton materialButton = h().e;
        m.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellLearnMore");
        materialButton.setVisibility(i() ? 0 : 8);
        h().e.setOnClickListener(new a(1, this));
        MaterialButton materialButton2 = h().d;
        m.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellGetPremium");
        materialButton2.setVisibility(i() ^ true ? 0 : 8);
        h().d.setOnClickListener(new a(2, this));
    }
}
