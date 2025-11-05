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
import b.a.i.y3;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StepsView.kt */
/* loaded from: classes2.dex */
public final class StepsView extends RelativeLayout {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public final y3 binding;

    /* renamed from: l, reason: from kotlin metadata */
    public d pagerAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    public ViewPager2.OnPageChangeCallback pagerAdapterChangeCallback;

    /* compiled from: java-style lambda group */
    /* loaded from: classes.dex */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ Object l;
        public final /* synthetic */ Object m;

        public a(int i, int i2, Object obj, Object obj2) {
            this.j = i;
            this.k = i2;
            this.l = obj;
            this.m = obj2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i != 0) {
                if (i != 1) {
                    throw null;
                }
                Function1<View, Unit> function1 = ((b) ((List) this.l).get(this.k)).f;
                if (function1 == null) {
                    ((Function0) this.m).invoke();
                    return;
                } else {
                    m.checkNotNullExpressionValue(view, "it");
                    function1.invoke(view);
                    return;
                }
            }
            Function1<View, Unit> function12 = ((b) ((List) this.m).get(this.k)).d;
            if (function12 != null) {
                m.checkNotNullExpressionValue(view, "it");
                function12.invoke(view);
                return;
            }
            ViewPager2 viewPager2 = ((StepsView) this.l).binding.i;
            m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
            int currentItem = viewPager2.getCurrentItem();
            if (((StepsView) this.l).pagerAdapter == null || currentItem != r1.getItemCount() - 1) {
                ViewPager2 viewPager22 = ((StepsView) this.l).binding.i;
                m.checkNotNullExpressionValue(viewPager22, "binding.stepsViewpager");
                ViewPager2 viewPager23 = ((StepsView) this.l).binding.i;
                m.checkNotNullExpressionValue(viewPager23, "binding.stepsViewpager");
                viewPager22.setCurrentItem(viewPager23.getCurrentItem() + 1);
            }
        }
    }

    /* compiled from: StepsView.kt */
    public static abstract class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2843b;
        public final int c;
        public final Function1<View, Unit> d;
        public final Function1<View, Unit> e;
        public final Function1<View, Unit> f;
        public final boolean g;
        public final boolean h;
        public final boolean i;

        /* compiled from: StepsView.kt */
        public static final class a extends b {
            public final Class<? extends Fragment> j;
            public final int k;
            public final int l;
            public final int m;
            public final Bundle n;
            public final Function1<View, Unit> o;
            public final Function1<View, Unit> p;
            public final Function1<View, Unit> q;
            public final boolean r;

            /* renamed from: s, reason: collision with root package name */
            public final boolean f2844s;
            public final boolean t;

            /* JADX WARN: Illegal instructions before constructor call */
            public a(Class cls, int i, int i2, int i3, Bundle bundle, Function1 function1, Function1 function12, Function1 function13, boolean z2, boolean z3, boolean z4, int i4) {
                int i5 = (i4 & 2) != 0 ? R.string.next : i;
                int i6 = (i4 & 4) != 0 ? R.string.back : i2;
                int i7 = (i4 & 8) != 0 ? R.string.done : i3;
                Bundle bundle2 = (i4 & 16) != 0 ? null : bundle;
                Function1 function14 = (i4 & 32) != 0 ? null : function1;
                int i8 = i4 & 64;
                Function1 function15 = (i4 & 128) == 0 ? function13 : null;
                boolean z5 = (i4 & 256) != 0 ? true : z2;
                boolean z6 = (i4 & 512) != 0 ? true : z3;
                boolean z7 = (i4 & 1024) == 0 ? z4 : true;
                m.checkNotNullParameter(cls, "fragment");
                super(i5, i6, i7, function14, null, function15, z5, z6, z7, null);
                this.j = cls;
                this.k = i5;
                this.l = i6;
                this.m = i7;
                this.n = bundle2;
                this.o = function14;
                this.p = null;
                this.q = function15;
                this.r = z5;
                this.f2844s = z6;
                this.t = z7;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return m.areEqual(this.j, aVar.j) && this.k == aVar.k && this.l == aVar.l && this.m == aVar.m && m.areEqual(this.n, aVar.n) && m.areEqual(this.o, aVar.o) && m.areEqual(this.p, aVar.p) && m.areEqual(this.q, aVar.q) && this.r == aVar.r && this.f2844s == aVar.f2844s && this.t == aVar.t;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Class<? extends Fragment> cls = this.j;
                int iHashCode = (((((((cls != null ? cls.hashCode() : 0) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
                Bundle bundle = this.n;
                int iHashCode2 = (iHashCode + (bundle != null ? bundle.hashCode() : 0)) * 31;
                Function1<View, Unit> function1 = this.o;
                int iHashCode3 = (iHashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
                Function1<View, Unit> function12 = this.p;
                int iHashCode4 = (iHashCode3 + (function12 != null ? function12.hashCode() : 0)) * 31;
                Function1<View, Unit> function13 = this.q;
                int iHashCode5 = (iHashCode4 + (function13 != null ? function13.hashCode() : 0)) * 31;
                boolean z2 = this.r;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode5 + i) * 31;
                boolean z3 = this.f2844s;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.t;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("FragmentStep(fragment=");
                sbU.append(this.j);
                sbU.append(", nextText=");
                sbU.append(this.k);
                sbU.append(", cancelText=");
                sbU.append(this.l);
                sbU.append(", doneText=");
                sbU.append(this.m);
                sbU.append(", arguments=");
                sbU.append(this.n);
                sbU.append(", onNext=");
                sbU.append(this.o);
                sbU.append(", onCancel=");
                sbU.append(this.p);
                sbU.append(", onDone=");
                sbU.append(this.q);
                sbU.append(", canNext=");
                sbU.append(this.r);
                sbU.append(", canCancel=");
                sbU.append(this.f2844s);
                sbU.append(", allowScroll=");
                return b.d.b.a.a.O(sbU, this.t, ")");
            }
        }

        /* compiled from: StepsView.kt */
        /* renamed from: com.discord.views.steps.StepsView$b$b, reason: collision with other inner class name */
        public static final class C0355b extends b {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0355b)) {
                    return false;
                }
                Objects.requireNonNull((C0355b) obj);
                return m.areEqual((Object) null, (Object) null) && m.areEqual((Object) null, (Object) null) && m.areEqual((Object) null, (Object) null);
            }

            public int hashCode() {
                return (((((((((((((((((0 * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0;
            }

            public String toString() {
                return "ViewStep(layoutId=0, nextText=0, cancelText=0, doneText=0, onNext=null, onCancel=null, onDone=null, canNext=false, canCancel=false, allowScroll=false)";
            }
        }

        public b(int i, int i2, int i3, Function1 function1, Function1 function12, Function1 function13, boolean z2, boolean z3, boolean z4, DefaultConstructorMarker defaultConstructorMarker) {
            this.a = i;
            this.f2843b = i2;
            this.c = i3;
            this.d = function1;
            this.e = function12;
            this.f = function13;
            this.g = z2;
            this.h = z3;
            this.i = z4;
        }
    }

    /* compiled from: StepsView.kt */
    public static final class c extends AppFragment {
        public c(@LayoutRes int i) {
            super(i);
        }
    }

    /* compiled from: StepsView.kt */
    public static final class d extends FragmentStateAdapter {
        public List<? extends b> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment, List<? extends b> list) {
            super(fragment);
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(list, "steps");
            this.a = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) throws IllegalAccessException, InstantiationException {
            b bVar = this.a.get(i);
            if (!(bVar instanceof b.a)) {
                if (!(bVar instanceof b.C0355b)) {
                    return new Fragment();
                }
                Objects.requireNonNull((b.C0355b) bVar);
                return new c(0);
            }
            b.a aVar = (b.a) bVar;
            Fragment fragmentNewInstance = aVar.j.newInstance();
            Fragment fragment = fragmentNewInstance;
            fragment.setArguments(aVar.n);
            m.checkNotNullExpressionValue(fragmentNewInstance, "currentStep.fragment.new…tep.arguments\n          }");
            return fragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }
    }

    /* compiled from: StepsView.kt */
    public static final class e extends ViewPager2.OnPageChangeCallback {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f2845b;
        public final /* synthetic */ Function0 c;

        public e(Function1 function1, Function0 function0) {
            this.f2845b = function1;
            this.c = function0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            this.f2845b.invoke(Integer.valueOf(i));
            StepsView stepsView = StepsView.this;
            Function0<Unit> function0 = this.c;
            int i2 = StepsView.j;
            stepsView.c(i, function0);
            StepsView.this.binding.g.setCurrentStepIndex(i);
        }
    }

    /* compiled from: StepsView.kt */
    public static final class f implements View.OnClickListener {
        public final /* synthetic */ Function0 j;

        public f(Function0 function0) {
            this.j = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.j.invoke();
        }
    }

    /* compiled from: StepsView.kt */
    public static final class g implements View.OnClickListener {
        public final /* synthetic */ List k;
        public final /* synthetic */ int l;
        public final /* synthetic */ Function0 m;

        public g(List list, int i, Function0 function0) {
            this.k = list;
            this.l = i;
            this.m = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<View, Unit> function1 = ((b) this.k.get(this.l)).e;
            if (function1 != null) {
                m.checkNotNullExpressionValue(view, "it");
                function1.invoke(view);
                return;
            }
            ViewPager2 viewPager2 = StepsView.this.binding.i;
            m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
            if (viewPager2.getCurrentItem() == 0) {
                this.m.invoke();
                return;
            }
            ViewPager2 viewPager22 = StepsView.this.binding.i;
            m.checkNotNullExpressionValue(viewPager22, "binding.stepsViewpager");
            m.checkNotNullExpressionValue(StepsView.this.binding.i, "binding.stepsViewpager");
            viewPager22.setCurrentItem(r1.getCurrentItem() - 1);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_steps, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.steps_button_container;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.steps_button_container);
        if (linearLayout != null) {
            i = R.id.steps_cancel;
            TextView textView = (TextView) viewInflate.findViewById(R.id.steps_cancel);
            if (textView != null) {
                i = R.id.steps_close;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.steps_close);
                if (imageView != null) {
                    i = R.id.steps_done;
                    LoadingButton loadingButton = (LoadingButton) viewInflate.findViewById(R.id.steps_done);
                    if (loadingButton != null) {
                        i = R.id.steps_next;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.steps_next);
                        if (materialButton != null) {
                            i = R.id.steps_progress_indicator;
                            StepsProgressIndicatorView stepsProgressIndicatorView = (StepsProgressIndicatorView) viewInflate.findViewById(R.id.steps_progress_indicator);
                            if (stepsProgressIndicatorView != null) {
                                i = R.id.steps_title;
                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.steps_title);
                                if (textView2 != null) {
                                    i = R.id.steps_viewpager;
                                    ViewPager2 viewPager2 = (ViewPager2) viewInflate.findViewById(R.id.steps_viewpager);
                                    if (viewPager2 != null) {
                                        y3 y3Var = new y3((RelativeLayout) viewInflate, linearLayout, textView, imageView, loadingButton, materialButton, stepsProgressIndicatorView, textView2, viewPager2);
                                        m.checkNotNullExpressionValue(y3Var, "ViewStepsBinding.inflate…rom(context), this, true)");
                                        this.binding = y3Var;
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

    public final void a(d adapter, Function0<Unit> onClose, Function1<? super Integer, Unit> onPageSelected) {
        m.checkNotNullParameter(adapter, "adapter");
        m.checkNotNullParameter(onClose, "onClose");
        m.checkNotNullParameter(onPageSelected, "onPageSelected");
        this.pagerAdapter = adapter;
        ViewPager2 viewPager2 = this.binding.i;
        m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        viewPager2.setAdapter(this.pagerAdapter);
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.pagerAdapterChangeCallback;
        if (onPageChangeCallback != null) {
            this.binding.i.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
        ViewPager2 viewPager22 = this.binding.i;
        e eVar = new e(onPageSelected, onClose);
        this.pagerAdapterChangeCallback = eVar;
        viewPager22.registerOnPageChangeCallback(eVar);
        c(0, onClose);
        this.binding.g.setTotalStepCount(adapter.a.size());
    }

    public final void b(int index) {
        if (index >= 0) {
            d dVar = this.pagerAdapter;
            if (index < (dVar != null ? dVar.getItemCount() : 0)) {
                ViewPager2 viewPager2 = this.binding.i;
                m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
                viewPager2.setCurrentItem(index);
            }
        }
    }

    public final void c(int position, Function0<Unit> onClose) {
        List<? extends b> list;
        this.binding.d.setOnClickListener(new f(onClose));
        d dVar = this.pagerAdapter;
        if (dVar == null || (list = dVar.a) == null) {
            return;
        }
        ViewPager2 viewPager2 = this.binding.i;
        m.checkNotNullExpressionValue(viewPager2, "binding.stepsViewpager");
        viewPager2.setUserInputEnabled(list.get(position).i);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.stepsCancel");
        textView.setText(getContext().getString(list.get(position).f2843b));
        this.binding.e.setText(getContext().getString(list.get(position).c));
        MaterialButton materialButton = this.binding.f;
        m.checkNotNullExpressionValue(materialButton, "binding.stepsNext");
        materialButton.setText(getContext().getString(list.get(position).a));
        this.binding.f.setOnClickListener(new a(0, position, this, list));
        this.binding.c.setOnClickListener(new g(list, position, onClose));
        boolean z2 = true;
        this.binding.e.setOnClickListener(new a(1, position, list, onClose));
        d dVar2 = this.pagerAdapter;
        boolean z3 = dVar2 != null && position == dVar2.getItemCount() - 1;
        MaterialButton materialButton2 = this.binding.f;
        m.checkNotNullExpressionValue(materialButton2, "binding.stepsNext");
        materialButton2.setVisibility(!z3 && list.get(position).g ? 0 : 8);
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.stepsCancel");
        textView2.setVisibility(!z3 && list.get(position).h ? 0 : 8);
        LoadingButton loadingButton = this.binding.e;
        m.checkNotNullExpressionValue(loadingButton, "binding.stepsDone");
        loadingButton.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout = this.binding.f236b;
        m.checkNotNullExpressionValue(linearLayout, "binding.stepsButtonContainer");
        MaterialButton materialButton3 = this.binding.f;
        m.checkNotNullExpressionValue(materialButton3, "binding.stepsNext");
        if (!(materialButton3.getVisibility() == 0)) {
            TextView textView3 = this.binding.c;
            m.checkNotNullExpressionValue(textView3, "binding.stepsCancel");
            if (!(textView3.getVisibility() == 0)) {
                LoadingButton loadingButton2 = this.binding.e;
                m.checkNotNullExpressionValue(loadingButton2, "binding.stepsDone");
                if (!(loadingButton2.getVisibility() == 0)) {
                    z2 = false;
                }
            }
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
    }

    public final void setIsDoneButtonEnabled(boolean isEnabled) {
        LoadingButton loadingButton = this.binding.e;
        m.checkNotNullExpressionValue(loadingButton, "binding.stepsDone");
        loadingButton.setEnabled(isEnabled);
    }

    public final void setIsLoading(boolean isLoading) {
        this.binding.e.setIsLoading(isLoading);
    }

    public final void setIsNextButtonEnabled(boolean isEnabled) {
        MaterialButton materialButton = this.binding.f;
        m.checkNotNullExpressionValue(materialButton, "binding.stepsNext");
        materialButton.setEnabled(isEnabled);
    }

    public final void setIsTitleVisible(boolean isVisible) {
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.stepsTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            StepsProgressIndicatorView stepsProgressIndicatorView = this.binding.g;
            m.checkNotNullExpressionValue(stepsProgressIndicatorView, "binding.stepsProgressIndicator");
            stepsProgressIndicatorView.setVisibility(8);
        }
    }

    public final void setStepProgressIndicatorVisible(boolean isVisible) {
        StepsProgressIndicatorView stepsProgressIndicatorView = this.binding.g;
        m.checkNotNullExpressionValue(stepsProgressIndicatorView, "binding.stepsProgressIndicator");
        stepsProgressIndicatorView.setVisibility(isVisible ? 0 : 8);
        if (isVisible) {
            TextView textView = this.binding.h;
            m.checkNotNullExpressionValue(textView, "binding.stepsTitle");
            textView.setVisibility(8);
        }
    }

    public final void setTitle(String title) {
        m.checkNotNullParameter(title, "title");
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.stepsTitle");
        textView.setText(title);
    }
}
