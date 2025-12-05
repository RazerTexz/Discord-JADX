package com.discord.views.steps;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.ViewStepsBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StepsView.kt */
/* loaded from: classes2.dex */
public final class StepsView extends RelativeLayout {

    /* renamed from: j */
    public static final /* synthetic */ int f19295j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final ViewStepsBinding binding;

    /* renamed from: l, reason: from kotlin metadata */
    public C7125d pagerAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    public ViewPager2.OnPageChangeCallback pagerAdapterChangeCallback;

    /* compiled from: java-style lambda group */
    /* renamed from: com.discord.views.steps.StepsView$a */
    /* loaded from: classes.dex */
    public static final class ViewOnClickListenerC7122a implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ int f19299j;

        /* renamed from: k */
        public final /* synthetic */ int f19300k;

        /* renamed from: l */
        public final /* synthetic */ Object f19301l;

        /* renamed from: m */
        public final /* synthetic */ Object f19302m;

        public ViewOnClickListenerC7122a(int i, int i2, Object obj, Object obj2) {
            this.f19299j = i;
            this.f19300k = i2;
            this.f19301l = obj;
            this.f19302m = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f19299j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                Function1<View, Unit> function1 = ((AbstractC7123b) ((List) this.f19301l).get(this.f19300k)).f19308f;
                if (function1 == null) {
                    ((Function0) this.f19302m).invoke();
                    return;
                } else {
                    Intrinsics3.checkNotNullExpressionValue(view, "it");
                    function1.invoke(view);
                    return;
                }
            }
            Function1<View, Unit> function12 = ((AbstractC7123b) ((List) this.f19302m).get(this.f19300k)).f19306d;
            if (function12 != null) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                function12.invoke(view);
                return;
            }
            ViewPager2 viewPager2 = ((StepsView) this.f19301l).binding.f1425i;
            Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
            int currentItem = viewPager2.getCurrentItem();
            if (((StepsView) this.f19301l).pagerAdapter == null || currentItem != r1.getItemCount() - 1) {
                ViewPager2 viewPager22 = ((StepsView) this.f19301l).binding.f1425i;
                Intrinsics3.checkNotNullExpressionValue(viewPager22, "binding.stepsViewpager");
                ViewPager2 viewPager23 = ((StepsView) this.f19301l).binding.f1425i;
                Intrinsics3.checkNotNullExpressionValue(viewPager23, "binding.stepsViewpager");
                viewPager22.setCurrentItem(viewPager23.getCurrentItem() + 1);
            }
        }
    }

    /* compiled from: StepsView.kt */
    /* renamed from: com.discord.views.steps.StepsView$b */
    public static abstract class AbstractC7123b {

        /* renamed from: a */
        public final int f19303a;

        /* renamed from: b */
        public final int f19304b;

        /* renamed from: c */
        public final int f19305c;

        /* renamed from: d */
        public final Function1<View, Unit> f19306d;

        /* renamed from: e */
        public final Function1<View, Unit> f19307e;

        /* renamed from: f */
        public final Function1<View, Unit> f19308f;

        /* renamed from: g */
        public final boolean f19309g;

        /* renamed from: h */
        public final boolean f19310h;

        /* renamed from: i */
        public final boolean f19311i;

        /* compiled from: StepsView.kt */
        /* renamed from: com.discord.views.steps.StepsView$b$a */
        public static final class a extends AbstractC7123b {

            /* renamed from: j */
            public final Class<? extends Fragment> f19312j;

            /* renamed from: k */
            public final int f19313k;

            /* renamed from: l */
            public final int f19314l;

            /* renamed from: m */
            public final int f19315m;

            /* renamed from: n */
            public final Bundle f19316n;

            /* renamed from: o */
            public final Function1<View, Unit> f19317o;

            /* renamed from: p */
            public final Function1<View, Unit> f19318p;

            /* renamed from: q */
            public final Function1<View, Unit> f19319q;

            /* renamed from: r */
            public final boolean f19320r;

            /* renamed from: s */
            public final boolean f19321s;

            /* renamed from: t */
            public final boolean f19322t;

            /* JADX WARN: Illegal instructions before constructor call */
            public a(Class cls, int i, int i2, int i3, Bundle bundle, Function1 function1, Function1 function12, Function1 function13, boolean z2, boolean z3, boolean z4, int i4) {
                int i5 = (i4 & 2) != 0 ? C5419R.string.next : i;
                int i6 = (i4 & 4) != 0 ? C5419R.string.back : i2;
                int i7 = (i4 & 8) != 0 ? C5419R.string.done : i3;
                Bundle bundle2 = (i4 & 16) != 0 ? null : bundle;
                Function1 function14 = (i4 & 32) != 0 ? null : function1;
                int i8 = i4 & 64;
                Function1 function15 = (i4 & 128) == 0 ? function13 : null;
                boolean z5 = (i4 & 256) != 0 ? true : z2;
                boolean z6 = (i4 & 512) != 0 ? true : z3;
                boolean z7 = (i4 & 1024) == 0 ? z4 : true;
                Intrinsics3.checkNotNullParameter(cls, "fragment");
                super(i5, i6, i7, function14, null, function15, z5, z6, z7, null);
                this.f19312j = cls;
                this.f19313k = i5;
                this.f19314l = i6;
                this.f19315m = i7;
                this.f19316n = bundle2;
                this.f19317o = function14;
                this.f19318p = null;
                this.f19319q = function15;
                this.f19320r = z5;
                this.f19321s = z6;
                this.f19322t = z7;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics3.areEqual(this.f19312j, aVar.f19312j) && this.f19313k == aVar.f19313k && this.f19314l == aVar.f19314l && this.f19315m == aVar.f19315m && Intrinsics3.areEqual(this.f19316n, aVar.f19316n) && Intrinsics3.areEqual(this.f19317o, aVar.f19317o) && Intrinsics3.areEqual(this.f19318p, aVar.f19318p) && Intrinsics3.areEqual(this.f19319q, aVar.f19319q) && this.f19320r == aVar.f19320r && this.f19321s == aVar.f19321s && this.f19322t == aVar.f19322t;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Class<? extends Fragment> cls = this.f19312j;
                int iHashCode = (((((((cls != null ? cls.hashCode() : 0) * 31) + this.f19313k) * 31) + this.f19314l) * 31) + this.f19315m) * 31;
                Bundle bundle = this.f19316n;
                int iHashCode2 = (iHashCode + (bundle != null ? bundle.hashCode() : 0)) * 31;
                Function1<View, Unit> function1 = this.f19317o;
                int iHashCode3 = (iHashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
                Function1<View, Unit> function12 = this.f19318p;
                int iHashCode4 = (iHashCode3 + (function12 != null ? function12.hashCode() : 0)) * 31;
                Function1<View, Unit> function13 = this.f19319q;
                int iHashCode5 = (iHashCode4 + (function13 != null ? function13.hashCode() : 0)) * 31;
                boolean z2 = this.f19320r;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                boolean z3 = this.f19321s;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.f19322t;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("FragmentStep(fragment=");
                sbM833U.append(this.f19312j);
                sbM833U.append(", nextText=");
                sbM833U.append(this.f19313k);
                sbM833U.append(", cancelText=");
                sbM833U.append(this.f19314l);
                sbM833U.append(", doneText=");
                sbM833U.append(this.f19315m);
                sbM833U.append(", arguments=");
                sbM833U.append(this.f19316n);
                sbM833U.append(", onNext=");
                sbM833U.append(this.f19317o);
                sbM833U.append(", onCancel=");
                sbM833U.append(this.f19318p);
                sbM833U.append(", onDone=");
                sbM833U.append(this.f19319q);
                sbM833U.append(", canNext=");
                sbM833U.append(this.f19320r);
                sbM833U.append(", canCancel=");
                sbM833U.append(this.f19321s);
                sbM833U.append(", allowScroll=");
                return outline.m827O(sbM833U, this.f19322t, ")");
            }
        }

        /* compiled from: StepsView.kt */
        /* renamed from: com.discord.views.steps.StepsView$b$b */
        public static final class b extends AbstractC7123b {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                Objects.requireNonNull((b) obj);
                return Intrinsics3.areEqual((Object) null, (Object) null) && Intrinsics3.areEqual((Object) null, (Object) null) && Intrinsics3.areEqual((Object) null, (Object) null);
            }

            public int hashCode() {
                return (((((((((((((((((0 * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0;
            }

            public String toString() {
                return "ViewStep(layoutId=0, nextText=0, cancelText=0, doneText=0, onNext=null, onCancel=null, onDone=null, canNext=false, canCancel=false, allowScroll=false)";
            }
        }

        public AbstractC7123b(int i, int i2, int i3, Function1 function1, Function1 function12, Function1 function13, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
            this.f19303a = i;
            this.f19304b = i2;
            this.f19305c = i3;
            this.f19306d = function1;
            this.f19307e = function12;
            this.f19308f = function13;
            this.f19309g = z2;
            this.f19310h = z3;
            this.f19311i = z4;
        }
    }

    /* compiled from: StepsView.kt */
    /* renamed from: com.discord.views.steps.StepsView$c */
    public static final class C7124c extends AppFragment {
        public C7124c(@LayoutRes int i) {
            super(i);
        }
    }

    /* compiled from: StepsView.kt */
    /* renamed from: com.discord.views.steps.StepsView$d */
    public static final class C7125d extends FragmentStateAdapter {

        /* renamed from: a */
        public List<? extends AbstractC7123b> f19323a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7125d(Fragment fragment, List<? extends AbstractC7123b> list) {
            super(fragment);
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(list, "steps");
            this.f19323a = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) throws IllegalAccessException, InstantiationException {
            AbstractC7123b abstractC7123b = this.f19323a.get(i);
            if (!(abstractC7123b instanceof AbstractC7123b.a)) {
                if (!(abstractC7123b instanceof AbstractC7123b.b)) {
                    return new Fragment();
                }
                Objects.requireNonNull((AbstractC7123b.b) abstractC7123b);
                return new C7124c(0);
            }
            AbstractC7123b.a aVar = (AbstractC7123b.a) abstractC7123b;
            Fragment fragmentNewInstance = aVar.f19312j.newInstance();
            Fragment fragment = fragmentNewInstance;
            fragment.setArguments(aVar.f19316n);
            Intrinsics3.checkNotNullExpressionValue(fragmentNewInstance, "currentStep.fragment.new…tep.arguments\n          }");
            return fragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f19323a.size();
        }
    }

    /* compiled from: StepsView.kt */
    /* renamed from: com.discord.views.steps.StepsView$e */
    public static final class C7126e extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b */
        public final /* synthetic */ Function1 f19325b;

        /* renamed from: c */
        public final /* synthetic */ Function0 f19326c;

        public C7126e(Function1 function1, Function0 function0) {
            this.f19325b = function1;
            this.f19326c = function0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            this.f19325b.invoke(Integer.valueOf(i));
            StepsView stepsView = StepsView.this;
            Function0<Unit> function0 = this.f19326c;
            int i2 = StepsView.f19295j;
            stepsView.m8611c(i, function0);
            StepsView.this.binding.f1423g.setCurrentStepIndex(i);
        }
    }

    /* compiled from: StepsView.kt */
    /* renamed from: com.discord.views.steps.StepsView$f */
    public static final class ViewOnClickListenerC7127f implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ Function0 f19327j;

        public ViewOnClickListenerC7127f(Function0 function0) {
            this.f19327j = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f19327j.invoke();
        }
    }

    /* compiled from: StepsView.kt */
    /* renamed from: com.discord.views.steps.StepsView$g */
    public static final class ViewOnClickListenerC7128g implements View.OnClickListener {

        /* renamed from: k */
        public final /* synthetic */ List f19329k;

        /* renamed from: l */
        public final /* synthetic */ int f19330l;

        /* renamed from: m */
        public final /* synthetic */ Function0 f19331m;

        public ViewOnClickListenerC7128g(List list, int i, Function0 function0) {
            this.f19329k = list;
            this.f19330l = i;
            this.f19331m = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<View, Unit> function1 = ((AbstractC7123b) this.f19329k.get(this.f19330l)).f19307e;
            if (function1 != null) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                function1.invoke(view);
                return;
            }
            ViewPager2 viewPager2 = StepsView.this.binding.f1425i;
            Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
            if (viewPager2.getCurrentItem() == 0) {
                this.f19331m.invoke();
                return;
            }
            ViewPager2 viewPager22 = StepsView.this.binding.f1425i;
            Intrinsics3.checkNotNullExpressionValue(viewPager22, "binding.stepsViewpager");
            Intrinsics3.checkNotNullExpressionValue(StepsView.this.binding.f1425i, "binding.stepsViewpager");
            viewPager22.setCurrentItem(r1.getCurrentItem() - 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_steps, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.steps_button_container;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.steps_button_container);
        if (linearLayout != null) {
            i = C5419R.id.steps_cancel;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.steps_cancel);
            if (textView != null) {
                i = C5419R.id.steps_close;
                ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.steps_close);
                if (imageView != null) {
                    i = C5419R.id.steps_done;
                    LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(C5419R.id.steps_done);
                    if (loadingButton != null) {
                        i = C5419R.id.steps_next;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.steps_next);
                        if (materialButton != null) {
                            i = C5419R.id.steps_progress_indicator;
                            StepsProgressIndicatorView stepsProgressIndicatorView = (StepsProgressIndicatorView) viewInflate.findViewById(C5419R.id.steps_progress_indicator);
                            if (stepsProgressIndicatorView != null) {
                                i = C5419R.id.steps_title;
                                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.steps_title);
                                if (textView2 != null) {
                                    i = C5419R.id.steps_viewpager;
                                    ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(C5419R.id.steps_viewpager);
                                    if (viewPager2 != null) {
                                        ViewStepsBinding viewStepsBinding = new ViewStepsBinding((RelativeLayout) viewInflate, linearLayout, textView, imageView, loadingButton, materialButton, stepsProgressIndicatorView, textView2, viewPager2);
                                        Intrinsics3.checkNotNullExpressionValue(viewStepsBinding, "ViewStepsBinding.inflate…rom(context), this, true)");
                                        this.binding = viewStepsBinding;
                                        setIsLoading(false);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* renamed from: a */
    public final void m8609a(C7125d adapter, Function0<Unit> onClose, Function1<? super Integer, Unit> onPageSelected) {
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        Intrinsics3.checkNotNullParameter(onClose, "onClose");
        Intrinsics3.checkNotNullParameter(onPageSelected, "onPageSelected");
        this.pagerAdapter = adapter;
        ViewPager2 viewPager2 = this.binding.f1425i;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        viewPager2.setAdapter(this.pagerAdapter);
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.pagerAdapterChangeCallback;
        if (onPageChangeCallback != null) {
            this.binding.f1425i.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
        ViewPager2 viewPager22 = this.binding.f1425i;
        C7126e c7126e = new C7126e(onPageSelected, onClose);
        this.pagerAdapterChangeCallback = c7126e;
        viewPager22.registerOnPageChangeCallback(c7126e);
        m8611c(0, onClose);
        this.binding.f1423g.setTotalStepCount(adapter.f19323a.size());
    }

    /* renamed from: b */
    public final void m8610b(int index) {
        if (index >= 0) {
            C7125d c7125d = this.pagerAdapter;
            if (index < (c7125d != null ? c7125d.getItemCount() : 0)) {
                ViewPager2 viewPager2 = this.binding.f1425i;
                Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
                viewPager2.setCurrentItem(index);
            }
        }
    }

    /* renamed from: c */
    public final void m8611c(int position, Function0<Unit> onClose) {
        List<? extends AbstractC7123b> list;
        this.binding.f1420d.setOnClickListener(new ViewOnClickListenerC7127f(onClose));
        C7125d c7125d = this.pagerAdapter;
        if (c7125d == null || (list = c7125d.f19323a) == null) {
            return;
        }
        ViewPager2 viewPager2 = this.binding.f1425i;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        viewPager2.setUserInputEnabled(list.get(position).f19311i);
        TextView textView = this.binding.f1419c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepsCancel");
        textView.setText(getContext().getString(list.get(position).f19304b));
        this.binding.f1421e.setText(getContext().getString(list.get(position).f19305c));
        MaterialButton materialButton = this.binding.f1422f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.stepsNext");
        materialButton.setText(getContext().getString(list.get(position).f19303a));
        this.binding.f1422f.setOnClickListener(new ViewOnClickListenerC7122a(0, position, this, list));
        this.binding.f1419c.setOnClickListener(new ViewOnClickListenerC7128g(list, position, onClose));
        boolean z2 = true;
        this.binding.f1421e.setOnClickListener(new ViewOnClickListenerC7122a(1, position, list, onClose));
        C7125d c7125d2 = this.pagerAdapter;
        boolean z3 = c7125d2 != null && position == c7125d2.getItemCount() - 1;
        MaterialButton materialButton2 = this.binding.f1422f;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.stepsNext");
        materialButton2.setVisibility(!z3 && list.get(position).f19309g ? 0 : 8);
        TextView textView2 = this.binding.f1419c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stepsCancel");
        textView2.setVisibility(!z3 && list.get(position).f19310h ? 0 : 8);
        LoadingButton loadingButton = this.binding.f1421e;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.stepsDone");
        loadingButton.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout = this.binding.f1418b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.stepsButtonContainer");
        MaterialButton materialButton3 = this.binding.f1422f;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.stepsNext");
        if (!(materialButton3.getVisibility() == 0)) {
            TextView textView3 = this.binding.f1419c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.stepsCancel");
            if (!(textView3.getVisibility() == 0)) {
                LoadingButton loadingButton2 = this.binding.f1421e;
                Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.stepsDone");
                if (!(loadingButton2.getVisibility() == 0)) {
                    z2 = false;
                }
            }
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
    }

    public final void setIsDoneButtonEnabled(boolean isEnabled) {
        LoadingButton loadingButton = this.binding.f1421e;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.stepsDone");
        loadingButton.setEnabled(isEnabled);
    }

    public final void setIsLoading(boolean isLoading) {
        this.binding.f1421e.setIsLoading(isLoading);
    }

    public final void setIsNextButtonEnabled(boolean isEnabled) {
        MaterialButton materialButton = this.binding.f1422f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.stepsNext");
        materialButton.setEnabled(isEnabled);
    }

    public final void setIsTitleVisible(boolean isVisible) {
        TextView textView = this.binding.f1424h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepsTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            StepsProgressIndicatorView stepsProgressIndicatorView = this.binding.f1423g;
            Intrinsics3.checkNotNullExpressionValue(stepsProgressIndicatorView, "binding.stepsProgressIndicator");
            stepsProgressIndicatorView.setVisibility(8);
        }
    }

    public final void setStepProgressIndicatorVisible(boolean isVisible) {
        StepsProgressIndicatorView stepsProgressIndicatorView = this.binding.f1423g;
        Intrinsics3.checkNotNullExpressionValue(stepsProgressIndicatorView, "binding.stepsProgressIndicator");
        stepsProgressIndicatorView.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            TextView textView = this.binding.f1424h;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepsTitle");
            textView.setVisibility(8);
        }
    }

    public final void setTitle(String title) {
        Intrinsics3.checkNotNullParameter(title, "title");
        TextView textView = this.binding.f1424h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepsTitle");
        textView.setText(title);
    }
}
