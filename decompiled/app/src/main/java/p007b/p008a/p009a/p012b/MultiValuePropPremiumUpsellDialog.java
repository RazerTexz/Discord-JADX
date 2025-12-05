package p007b.p008a.p009a.p012b;

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
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.MultiValuePropPremiumUpsellDialogBinding;
import p007b.p008a.p025i.WidgetPremiumUpsellBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* renamed from: b.a.a.b.c, reason: use source file name */
/* loaded from: classes.dex */
public final class MultiValuePropPremiumUpsellDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f264j = {outline.m846d0(MultiValuePropPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public e pagerAdapter;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.b.c$a */
    public static final class a implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ int f268j;

        /* renamed from: k */
        public final /* synthetic */ Object f269k;

        public a(int i, Object obj) {
            this.f268j = i;
            this.f269k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f268j;
            if (i == 0) {
                ((MultiValuePropPremiumUpsellDialog) this.f269k).dismiss();
            } else if (i == 1) {
                MultiValuePropPremiumUpsellDialog.m110g((MultiValuePropPremiumUpsellDialog) this.f269k);
            } else {
                if (i != 2) {
                    throw null;
                }
                MultiValuePropPremiumUpsellDialog.m110g((MultiValuePropPremiumUpsellDialog) this.f269k);
            }
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.c$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static void m114a(Companion companion, FragmentManager fragmentManager, int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3, int i2) {
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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            MultiValuePropPremiumUpsellDialog multiValuePropPremiumUpsellDialog = new MultiValuePropPremiumUpsellDialog();
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
            multiValuePropPremiumUpsellDialog.setArguments(bundle);
            multiValuePropPremiumUpsellDialog.show(fragmentManager, MultiValuePropPremiumUpsellDialog.class.getName());
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.c$c */
    public static final class c {

        /* renamed from: a */
        public final int f270a;

        /* renamed from: b */
        public CharSequence f271b;

        /* renamed from: c */
        public CharSequence f272c;

        public c(@DrawableRes int i, CharSequence charSequence, CharSequence charSequence2) {
            Intrinsics3.checkNotNullParameter(charSequence, "headerText");
            Intrinsics3.checkNotNullParameter(charSequence2, "bodyText");
            this.f270a = i;
            this.f271b = charSequence;
            this.f272c = charSequence2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f270a == cVar.f270a && Intrinsics3.areEqual(this.f271b, cVar.f271b) && Intrinsics3.areEqual(this.f272c, cVar.f272c);
        }

        public int hashCode() {
            int i = this.f270a * 31;
            CharSequence charSequence = this.f271b;
            int iHashCode = (i + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            CharSequence charSequence2 = this.f272c;
            return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("UpsellData(imageResId=");
            sbM833U.append(this.f270a);
            sbM833U.append(", headerText=");
            sbM833U.append(this.f271b);
            sbM833U.append(", bodyText=");
            return outline.m817E(sbM833U, this.f272c, ")");
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.c$d */
    public static final class d extends AppFragment {

        /* renamed from: j */
        public static final /* synthetic */ KProperty[] f273j = {outline.m846d0(d.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0)};

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
        /* renamed from: b.a.a.b.c$d$b */
        public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetPremiumUpsellBinding> {

            /* renamed from: j */
            public static final b f276j = new b();

            public b() {
                super(1, WidgetPremiumUpsellBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public WidgetPremiumUpsellBinding invoke(View view) {
                View view2 = view;
                Intrinsics3.checkNotNullParameter(view2, "p1");
                int i = C5419R.id.premium_upsell_body;
                TextView textView = (TextView) view2.findViewById(C5419R.id.premium_upsell_body);
                if (textView != null) {
                    i = C5419R.id.premium_upsell_header;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.premium_upsell_header);
                    if (textView2 != null) {
                        i = C5419R.id.premium_upsell_img;
                        ImageView imageView = (ImageView) view2.findViewById(C5419R.id.premium_upsell_img);
                        if (imageView != null) {
                            return new WidgetPremiumUpsellBinding((LinearLayout) view2, textView, textView2, imageView);
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
            }
        }

        public d() {
            super(C5419R.layout.widget_premium_upsell);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f276j, null, 2, null);
        }

        /* renamed from: g */
        public final WidgetPremiumUpsellBinding m115g() {
            return (WidgetPremiumUpsellBinding) this.binding.getValue((Fragment) this, f273j[0]);
        }

        @Override // com.discord.app.AppFragment
        public void onViewBoundOrOnResume() {
            String string;
            super.onViewBoundOrOnResume();
            ImageView imageView = m115g().f1299d;
            Bundle arguments = getArguments();
            imageView.setImageResource(arguments != null ? arguments.getInt("extra_image_id") : 0);
            TextView textView = m115g().f1298c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumUpsellHeader");
            Bundle arguments2 = getArguments();
            textView.setText(arguments2 != null ? arguments2.getString("extra_header_string") : null);
            TextView textView2 = m115g().f1297b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumUpsellBody");
            Bundle arguments3 = getArguments();
            textView2.setText((arguments3 == null || (string = arguments3.getString("extra_body_text")) == null) ? "" : FormatUtils.m220l(string, new Object[0], null, 2));
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.c$e */
    public static final class e extends FragmentStateAdapter {

        /* renamed from: a */
        public final List<c> f277a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment, List<c> list) {
            super(fragment);
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(list, "pages");
            this.f277a = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            c cVar = this.f277a.get(i);
            d.Companion companion = d.INSTANCE;
            int i2 = cVar.f270a;
            CharSequence charSequence = cVar.f271b;
            CharSequence charSequence2 = cVar.f272c;
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(charSequence, "headerText");
            Intrinsics3.checkNotNullParameter(charSequence2, "bodyText");
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
            return this.f277a.size();
        }
    }

    /* compiled from: MultiValuePropPremiumUpsellDialog.kt */
    /* renamed from: b.a.a.b.c$f */
    public static final /* synthetic */ class f extends FunctionReferenceImpl implements Function1<View, MultiValuePropPremiumUpsellDialogBinding> {

        /* renamed from: j */
        public static final f f278j = new f();

        public f() {
            super(1, MultiValuePropPremiumUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public MultiValuePropPremiumUpsellDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.premium_upsell_button_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.premium_upsell_button_container);
            if (linearLayout != null) {
                i = C5419R.id.premium_upsell_close;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.premium_upsell_close);
                if (materialButton != null) {
                    i = C5419R.id.premium_upsell_divider;
                    View viewFindViewById = view2.findViewById(C5419R.id.premium_upsell_divider);
                    if (viewFindViewById != null) {
                        i = C5419R.id.premium_upsell_dots;
                        TabLayout tabLayout = (TabLayout) view2.findViewById(C5419R.id.premium_upsell_dots);
                        if (tabLayout != null) {
                            i = C5419R.id.premium_upsell_get_premium;
                            MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.premium_upsell_get_premium);
                            if (materialButton2 != null) {
                                i = C5419R.id.premium_upsell_learn_more;
                                MaterialButton materialButton3 = (MaterialButton) view2.findViewById(C5419R.id.premium_upsell_learn_more);
                                if (materialButton3 != null) {
                                    i = C5419R.id.premium_upsell_viewpager;
                                    ViewPager2 viewPager2 = (ViewPager2) view2.findViewById(C5419R.id.premium_upsell_viewpager);
                                    if (viewPager2 != null) {
                                        return new MultiValuePropPremiumUpsellDialogBinding((RelativeLayout) view2, linearLayout, materialButton, viewFindViewById, tabLayout, materialButton2, materialButton3, viewPager2);
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

    public MultiValuePropPremiumUpsellDialog() {
        super(C5419R.layout.multi_value_prop_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, f.f278j, null, 2, null);
    }

    /* renamed from: g */
    public static final void m110g(MultiValuePropPremiumUpsellDialog multiValuePropPremiumUpsellDialog) {
        Bundle arguments = multiValuePropPremiumUpsellDialog.getArguments();
        String string = arguments != null ? arguments.getString("extra_page_name") : null;
        Bundle arguments2 = multiValuePropPremiumUpsellDialog.getArguments();
        String string2 = arguments2 != null ? arguments2.getString("extra_section_name") : null;
        Bundle arguments3 = multiValuePropPremiumUpsellDialog.getArguments();
        String string3 = arguments3 != null ? arguments3.getString("extra_object_name") : null;
        Bundle arguments4 = multiValuePropPremiumUpsellDialog.getArguments();
        AnalyticsTracker.INSTANCE.premiumSettingsOpened(new Traits.Location(string, string2, string3, arguments4 != null ? arguments4.getString("extra_object_type") : null, null, 16, null));
        WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
        Context contextRequireContext = multiValuePropPremiumUpsellDialog.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, null, 6, null);
        multiValuePropPremiumUpsellDialog.dismiss();
    }

    /* renamed from: h */
    public final MultiValuePropPremiumUpsellDialogBinding m111h() {
        return (MultiValuePropPremiumUpsellDialogBinding) this.binding.getValue((Fragment) this, f264j[0]);
    }

    /* renamed from: i */
    public final boolean m112i() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_learn_more");
    }

    /* renamed from: j */
    public final boolean m113j() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean("extra_show_other_pages");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        String string2;
        super.onCreate(savedInstanceState);
        AppDialog.hideKeyboard$default(this, null, 1, null);
        String string3 = getString(C5419R.string.premium_upsell_tag_passive_mobile);
        Intrinsics3.checkNotNullExpressionValue(string3, "getString(R.string.premi…psell_tag_passive_mobile)");
        String string4 = getString(C5419R.string.premium_upsell_tag_description_mobile);
        Intrinsics3.checkNotNullExpressionValue(string4, "getString(R.string.premi…l_tag_description_mobile)");
        String string5 = getString(C5419R.string.premium_upsell_emoji_passive_mobile);
        Intrinsics3.checkNotNullExpressionValue(string5, "getString(R.string.premi…ell_emoji_passive_mobile)");
        String string6 = getString(C5419R.string.premium_upsell_emoji_description_mobile);
        Intrinsics3.checkNotNullExpressionValue(string6, "getString(R.string.premi…emoji_description_mobile)");
        String string7 = getString(C5419R.string.premium_upsell_animated_emojis_passive_mobile);
        Intrinsics3.checkNotNullExpressionValue(string7, "getString(R.string.premi…ed_emojis_passive_mobile)");
        String string8 = getString(C5419R.string.premium_upsell_animated_emojis_description_mobile);
        Intrinsics3.checkNotNullExpressionValue(string8, "getString(R.string.premi…mojis_description_mobile)");
        CharSequence charSequenceM219k = FormatUtils.m219k(this, C5419R.string.premium_upsell_upload_passive_mobile, new Object[0], null, 4);
        Object[] objArr = {FormatUtils.m219k(this, C5419R.string.file_upload_limit_standard, new Object[0], null, 4), FormatUtils.m219k(this, C5419R.string.file_upload_limit_premium_tier_2, new Object[0], null, 4)};
        String string9 = getString(C5419R.string.premium_upsell_animated_avatar_passive_mobile);
        Intrinsics3.checkNotNullExpressionValue(string9, "getString(R.string.premi…ed_avatar_passive_mobile)");
        String string10 = getString(C5419R.string.premium_upsell_animated_avatar_description_mobile);
        Intrinsics3.checkNotNullExpressionValue(string10, "getString(R.string.premi…vatar_description_mobile)");
        String string11 = getString(C5419R.string.premium_upsell_badge_passive_mobile);
        Intrinsics3.checkNotNullExpressionValue(string11, "getString(R.string.premi…ell_badge_passive_mobile)");
        String string12 = getString(C5419R.string.premium_upsell_badge_description_mobile);
        Intrinsics3.checkNotNullExpressionValue(string12, "getString(R.string.premi…badge_description_mobile)");
        List listListOf = Collections2.listOf((Object[]) new c[]{new c(C5419R.drawable.img_tag_upsell, string3, string4), new c(C5419R.drawable.img_global_emoji_upsell, string5, string6), new c(C5419R.drawable.img_animated_emoji_upsell, string7, string8), new c(C5419R.drawable.img_upload_upsell, charSequenceM219k, FormatUtils.m219k(this, C5419R.string.premium_upsell_upload_description_mobile, objArr, null, 4)), new c(C5419R.drawable.img_avatar_upsell, string9, string10), new c(C5419R.drawable.img_badge_upsell, string11, string12)});
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("extra_page_number") : 0;
        Bundle arguments2 = getArguments();
        String str = "";
        if (arguments2 != null && arguments2.containsKey("extra_header_string")) {
            c cVar = (c) listListOf.get(i);
            Bundle arguments3 = getArguments();
            if (arguments3 == null || (string2 = arguments3.getString("extra_header_string")) == null) {
                string2 = "";
            }
            Objects.requireNonNull(cVar);
            Intrinsics3.checkNotNullParameter(string2, "<set-?>");
            cVar.f271b = string2;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null && arguments4.containsKey("extra_body_text")) {
            c cVar2 = (c) listListOf.get(i);
            Bundle arguments5 = getArguments();
            if (arguments5 != null && (string = arguments5.getString("extra_body_text")) != null) {
                str = string;
            }
            Objects.requireNonNull(cVar2);
            Intrinsics3.checkNotNullParameter(str, "<set-?>");
            cVar2.f272c = str;
        }
        c cVar3 = (c) listListOf.get(i);
        List listMutableListOf = Collections2.mutableListOf(cVar3);
        if (m113j()) {
            listMutableListOf.addAll(_Collections.minus(listListOf, cVar3));
        }
        this.pagerAdapter = new e(this, listMutableListOf);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ViewPager2 viewPager2 = m111h().f1337f;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.premiumUpsellViewpager");
        e eVar = this.pagerAdapter;
        if (eVar == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("pagerAdapter");
        }
        viewPager2.setAdapter(eVar);
        TabLayout tabLayout = m111h().f1334c;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.premiumUpsellDots");
        tabLayout.setVisibility(m113j() ? 0 : 8);
        TabLayout tabLayout2 = m111h().f1334c;
        Intrinsics3.checkNotNullExpressionValue(tabLayout2, "binding.premiumUpsellDots");
        ViewPager2 viewPager22 = m111h().f1337f;
        Intrinsics3.checkNotNullExpressionValue(viewPager22, "binding.premiumUpsellViewpager");
        ViewPager2Extensions.setUpWithViewPager2$default(tabLayout2, viewPager22, null, 2, null);
        m111h().f1333b.setOnClickListener(new a(0, this));
        MaterialButton materialButton = m111h().f1336e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.premiumUpsellLearnMore");
        materialButton.setVisibility(m112i() ? 0 : 8);
        m111h().f1336e.setOnClickListener(new a(1, this));
        MaterialButton materialButton2 = m111h().f1335d;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.premiumUpsellGetPremium");
        materialButton2.setVisibility(m112i() ^ true ? 0 : 8);
        m111h().f1335d.setOnClickListener(new a(2, this));
    }
}
