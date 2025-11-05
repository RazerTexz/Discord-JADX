package b.b.a.a;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import b.b.a.d.d;
import com.discord.utilities.color.ColorCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.t.c0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* compiled from: AddContentDialogFragment.kt */
/* loaded from: classes3.dex */
public class a extends AppCompatDialogFragment {
    public static final /* synthetic */ int j = 0;

    /* renamed from: k, reason: from kotlin metadata */
    public ViewPager contentPager;

    /* renamed from: l, reason: from kotlin metadata */
    public TabLayout contentTabs;

    /* renamed from: m, reason: from kotlin metadata */
    public FloatingActionButton actionButton;

    /* renamed from: n, reason: from kotlin metadata */
    public ImageView launchButton;

    /* renamed from: o, reason: from kotlin metadata */
    public SelectionAggregator<Attachment<Object>> selectionAggregator;

    /* renamed from: p, reason: from kotlin metadata */
    public Function1<? super View, Unit> onKeyboardSelectedListener;

    /* renamed from: q, reason: from kotlin metadata */
    public ViewPager.OnPageChangeListener onPageChangeListener;

    /* renamed from: r, reason: from kotlin metadata */
    public final c itemSelectionListener = new c();

    /* compiled from: java-style lambda group */
    /* renamed from: b.b.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class ViewOnClickListenerC0058a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public ViewOnClickListenerC0058a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws Resources.NotFoundException {
            int i = this.j;
            if (i == 0) {
                a aVar = (a) this.k;
                int i2 = a.j;
                if (aVar.isCancelable()) {
                    aVar.h(true);
                    return;
                }
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    throw null;
                }
                FlexInputFragment flexInputFragment = (FlexInputFragment) ((Fragment) this.k);
                FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onSendButtonClicked(flexInputFragment.inputListener);
                    return;
                }
                return;
            }
            a aVar2 = (a) this.k;
            Objects.requireNonNull(aVar2);
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            try {
                aVar2.startActivityForResult(intent, 5968);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(aVar2.getContext(), aVar2.getString(R.h.error_generic_title), 0).show();
            }
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ boolean k;

        public b(boolean z2) {
            this.k = z2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Function1<? super View, Unit> function1;
            d0.z.d.m.checkNotNullParameter(animation, "animation");
            a.this.dismissAllowingStateLoss();
            if (!this.k || (view = a.this.getView()) == null || (function1 = a.this.onKeyboardSelectedListener) == null) {
                return;
            }
            d0.z.d.m.checkNotNullExpressionValue(view, "it");
            function1.invoke(view);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            d0.z.d.m.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            d0.z.d.m.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    public static final class c implements SelectionCoordinator.ItemSelectionListener<Attachment<?>> {
        public c() {
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemSelected(Attachment<?> attachment) {
            d0.z.d.m.checkNotNullParameter(attachment, "item");
            a.g(a.this);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemUnselected(Attachment<?> attachment) {
            d0.z.d.m.checkNotNullParameter(attachment, "item");
            a.g(a.this);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void unregister() {
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    public static final class d extends AppCompatDialog {
        public d(a aVar, Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void show() {
            super.show();
            Window window = getWindow();
            if (window != null) {
                window.setLayout(-1, -1);
            }
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    public static final class e extends d0.z.d.o implements Function0<Unit> {
        public final /* synthetic */ Fragment $flexInputFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.$flexInputFragment = fragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() throws Resources.NotFoundException {
            TabLayout tabLayout;
            TabLayout.Tab tabAt;
            FragmentManager childFragmentManager = a.this.getChildFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            d.a[] aVarArrK = ((FlexInputFragment) this.$flexInputFragment).k();
            b.b.a.d.d dVar = new b.b.a.d.d(childFragmentManager, (d.a[]) Arrays.copyOf(aVarArrK, aVarArrK.length));
            a aVar = a.this;
            Objects.requireNonNull(aVar);
            d0.z.d.m.checkNotNullParameter(dVar, "pagerAdapter");
            Context context = aVar.getContext();
            if (context != null && (tabLayout = aVar.contentTabs) != null) {
                d0.z.d.m.checkNotNullExpressionValue(context, "context");
                d0.z.d.m.checkNotNullParameter(context, "context");
                d0.z.d.m.checkNotNullParameter(tabLayout, "tabLayout");
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context, R.c.tab_color_selector);
                int tabCount = tabLayout.getTabCount();
                for (int i = 0; i < tabCount; i++) {
                    TabLayout.Tab tabAt2 = tabLayout.getTabAt(i);
                    if (tabAt2 != null) {
                        d0.z.d.m.checkNotNullExpressionValue(colorStateList, "iconColors");
                        Drawable icon = tabAt2.getIcon();
                        if (icon != null) {
                            Drawable drawableWrap = DrawableCompat.wrap(icon);
                            DrawableCompat.setTintList(drawableWrap, colorStateList);
                            tabAt2.setIcon(drawableWrap);
                        }
                    }
                }
                d.a[] aVarArr = dVar.a;
                ArrayList arrayList = new ArrayList(aVarArr.length);
                for (d.a aVar2 : aVarArr) {
                    TabLayout.Tab icon2 = tabLayout.newTab().setIcon(aVar2.getIcon());
                    d0.z.d.m.checkNotNullExpressionValue(icon2, "tabLayout.newTab()\n              .setIcon(it.icon)");
                    d0.z.d.m.checkNotNullExpressionValue(colorStateList, "iconColors");
                    Drawable icon3 = icon2.getIcon();
                    if (icon3 != null) {
                        Drawable drawableWrap2 = DrawableCompat.wrap(icon3);
                        DrawableCompat.setTintList(drawableWrap2, colorStateList);
                        icon2.setIcon(drawableWrap2);
                    }
                    arrayList.add(icon2.setContentDescription(aVar2.getContentDesc()));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    tabLayout.addTab((TabLayout.Tab) it.next());
                }
                ViewPager viewPager = aVar.contentPager;
                if (viewPager != null) {
                    viewPager.setAdapter(dVar);
                }
                TabLayout tabLayout2 = aVar.contentTabs;
                if (tabLayout2 != null) {
                    tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b.b.a.a.b(aVar));
                }
                ViewPager viewPager2 = aVar.contentPager;
                if (viewPager2 != null) {
                    viewPager2.addOnPageChangeListener(new b.b.a.a.c(aVar));
                }
                TabLayout tabLayout3 = aVar.contentTabs;
                if (tabLayout3 != null && (tabAt = tabLayout3.getTabAt(0)) != null) {
                    tabAt.select();
                }
            }
            return Unit.a;
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    public static final class f extends AccessibilityDelegateCompat {
        public f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            d0.z.d.m.checkNotNullParameter(view, "host");
            d0.z.d.m.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
            ImageView imageView = a.this.launchButton;
            Objects.requireNonNull(imageView, "null cannot be cast to non-null type android.view.View");
            accessibilityNodeInfoCompat.setTraversalAfter(imageView);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    public static final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.g(a.this);
        }
    }

    public static final void g(a aVar) {
        FloatingActionButton floatingActionButton = aVar.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.post(new b.b.a.a.d(aVar));
        }
    }

    public final void h(boolean openKeyboard) throws Resources.NotFoundException {
        Context context = getContext();
        if (context == null) {
            dismissAllowingStateLoss();
            return;
        }
        d0.z.d.m.checkNotNullExpressionValue(context, "context ?: return dismissAllowingStateLoss()");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, com.google.android.material.R.anim.design_bottom_sheet_slide_out);
        d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation, "animation");
        animationLoadAnimation.setDuration(getResources().getInteger(com.google.android.material.R.integer.bottom_sheet_slide_duration));
        animationLoadAnimation.setInterpolator(context, android.R.anim.accelerate_decelerate_interpolator);
        FloatingActionButton floatingActionButton = this.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.hide();
        }
        TabLayout tabLayout = this.contentTabs;
        if (tabLayout != null) {
            tabLayout.startAnimation(animationLoadAnimation);
        }
        ViewPager viewPager = this.contentPager;
        if (viewPager != null) {
            viewPager.startAnimation(animationLoadAnimation);
        }
        ImageView imageView = this.launchButton;
        if (imageView != null) {
            imageView.startAnimation(animationLoadAnimation);
        }
        animationLoadAnimation.setAnimationListener(new b(openKeyboard));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intentData) {
        ContentResolver contentResolver;
        super.onActivityResult(requestCode, resultCode, intentData);
        if (5968 != requestCode || resultCode == 0) {
            return;
        }
        if (-1 != resultCode || intentData == null) {
            Toast.makeText(getContext(), "Error loading files", 0).show();
            return;
        }
        Context context = getContext();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        ClipData clipData = intentData.getClipData();
        ActivityResultCaller parentFragment = getParentFragment();
        Objects.requireNonNull(parentFragment, "null cannot be cast to non-null type com.lytefast.flexinput.FlexInputCoordinator<kotlin.Any>");
        b.b.a.b bVar = (b.b.a.b) parentFragment;
        if (clipData == null) {
            Uri data = intentData.getData();
            if (data != null) {
                bVar.f(Attachment.INSTANCE.b(data, contentResolver));
                return;
            }
            return;
        }
        IntRange intRangeUntil = d0.d0.f.until(0, clipData.getItemCount());
        ArrayList<Uri> arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ClipData.Item itemAt = clipData.getItemAt(((c0) it).nextInt());
            d0.z.d.m.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(it)");
            arrayList.add(itemAt.getUri());
        }
        for (Uri uri : arrayList) {
            Attachment.Companion companion = Attachment.INSTANCE;
            d0.z.d.m.checkNotNullExpressionValue(uri, "it");
            bVar.f(companion.b(uri, contentResolver));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @SuppressLint({"PrivateResource"})
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        d dVar = new d(this, getContext(), R.i.FlexInput_DialogWhenLarge);
        dVar.supportRequestWindowFeature(1);
        Window window = dVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(com.google.android.material.R.style.Animation_AppCompat_Dialog);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        return dVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws Resources.NotFoundException {
        d0.z.d.m.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.g.dialog_add_content_pager_with_fab, container, false);
        if (viewInflate != null) {
            viewInflate.setOnClickListener(new ViewOnClickListenerC0058a(0, this));
            this.contentPager = (ViewPager) viewInflate.findViewById(R.f.content_pager);
            this.contentTabs = (TabLayout) viewInflate.findViewById(R.f.content_tabs);
            this.actionButton = (FloatingActionButton) viewInflate.findViewById(R.f.action_btn);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.f.launch_btn);
            this.launchButton = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new ViewOnClickListenerC0058a(1, this));
            }
            FloatingActionButton floatingActionButton = this.actionButton;
            Objects.requireNonNull(floatingActionButton, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(viewInflate.getContext(), R.b.color_brand_500)));
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof FlexInputFragment) {
            FlexInputFragment flexInputFragment = (FlexInputFragment) parentFragment;
            e eVar = new e(parentFragment);
            Objects.requireNonNull(flexInputFragment);
            d0.z.d.m.checkNotNullParameter(eVar, "onContentPagesInitialized");
            try {
                flexInputFragment.k();
                eVar.invoke();
            } catch (UninitializedPropertyAccessException unused) {
                flexInputFragment.onContentPagesInitializedUpdates.add(eVar);
            }
            FloatingActionButton floatingActionButton2 = this.actionButton;
            if (floatingActionButton2 != null) {
                floatingActionButton2.setOnClickListener(new ViewOnClickListenerC0058a(2, parentFragment));
            }
            this.selectionAggregator = flexInputFragment.b().addItemSelectionListener(this.itemSelectionListener);
            FloatingActionButton floatingActionButton3 = this.actionButton;
            Objects.requireNonNull(floatingActionButton3, "null cannot be cast to non-null type android.view.View");
            ViewCompat.setAccessibilityDelegate(floatingActionButton3, new f());
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SelectionAggregator<Attachment<Object>> selectionAggregator = this.selectionAggregator;
        if (selectionAggregator != null) {
            selectionAggregator.removeItemSelectionListener(this.itemSelectionListener);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FloatingActionButton floatingActionButton = this.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.post(new g());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() throws Resources.NotFoundException {
        super.onStart();
        Context context = getContext();
        if (context != null) {
            d0.z.d.m.checkNotNullExpressionValue(context, "it");
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, com.google.android.material.R.anim.design_bottom_sheet_slide_in);
            d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation, "animation");
            animationLoadAnimation.setDuration(getResources().getInteger(com.google.android.material.R.integer.bottom_sheet_slide_duration));
            animationLoadAnimation.setInterpolator(context, android.R.anim.accelerate_decelerate_interpolator);
            TabLayout tabLayout = this.contentTabs;
            if (tabLayout != null) {
                tabLayout.startAnimation(animationLoadAnimation);
            }
            ViewPager viewPager = this.contentPager;
            if (viewPager != null) {
                viewPager.startAnimation(animationLoadAnimation);
            }
            ImageView imageView = this.launchButton;
            if (imageView != null) {
                imageView.startAnimation(animationLoadAnimation);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @SuppressLint({"PrivateResource"})
    public int show(FragmentTransaction transaction, String tag) {
        d0.z.d.m.checkNotNullParameter(transaction, "transaction");
        transaction.setCustomAnimations(com.google.android.material.R.anim.abc_grow_fade_in_from_bottom, com.google.android.material.R.anim.abc_shrink_fade_out_from_bottom);
        return super.show(transaction, tag);
    }
}
