package p007b.p076b.p077a.p078a;

import android.R;
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
import com.discord.utilities.color.ColorCompat;
import com.google.android.material.C10817R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.lytefast.flexinput.C11170R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import p007b.p076b.p077a.FlexInputCoordinator;
import p007b.p076b.p077a.p079d.AddContentPagerAdapter4;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Iterators4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: AddContentDialogFragment.kt */
/* renamed from: b.b.a.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public class AddContentDialogFragment extends AppCompatDialogFragment {

    /* renamed from: j */
    public static final /* synthetic */ int f2113j = 0;

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
    /* renamed from: b.b.a.a.a$a */
    /* loaded from: classes.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: j */
        public final /* synthetic */ int f2122j;

        /* renamed from: k */
        public final /* synthetic */ Object f2123k;

        public a(int i, Object obj) {
            this.f2122j = i;
            this.f2123k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws Resources.NotFoundException {
            int i = this.f2122j;
            if (i == 0) {
                AddContentDialogFragment addContentDialogFragment = (AddContentDialogFragment) this.f2123k;
                int i2 = AddContentDialogFragment.f2113j;
                if (addContentDialogFragment.isCancelable()) {
                    addContentDialogFragment.m395h(true);
                    return;
                }
                return;
            }
            if (i != 1) {
                if (i != 2) {
                    throw null;
                }
                FlexInputFragment flexInputFragment = (FlexInputFragment) ((Fragment) this.f2123k);
                FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onSendButtonClicked(flexInputFragment.inputListener);
                    return;
                }
                return;
            }
            AddContentDialogFragment addContentDialogFragment2 = (AddContentDialogFragment) this.f2123k;
            Objects.requireNonNull(addContentDialogFragment2);
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            try {
                addContentDialogFragment2.startActivityForResult(intent, 5968);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(addContentDialogFragment2.getContext(), addContentDialogFragment2.getString(C11170R.h.error_generic_title), 0).show();
            }
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    /* renamed from: b.b.a.a.a$b */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: k */
        public final /* synthetic */ boolean f2125k;

        public b(boolean z2) {
            this.f2125k = z2;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view;
            Function1<? super View, Unit> function1;
            Intrinsics3.checkNotNullParameter(animation, "animation");
            AddContentDialogFragment.this.dismissAllowingStateLoss();
            if (!this.f2125k || (view = AddContentDialogFragment.this.getView()) == null || (function1 = AddContentDialogFragment.this.onKeyboardSelectedListener) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            function1.invoke(view);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics3.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics3.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    /* renamed from: b.b.a.a.a$c */
    public static final class c implements SelectionCoordinator.ItemSelectionListener<Attachment<?>> {
        public c() {
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemSelected(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "item");
            AddContentDialogFragment.m394g(AddContentDialogFragment.this);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void onItemUnselected(Attachment<?> attachment) {
            Intrinsics3.checkNotNullParameter(attachment, "item");
            AddContentDialogFragment.m394g(AddContentDialogFragment.this);
        }

        @Override // com.lytefast.flexinput.utils.SelectionCoordinator.ItemSelectionListener
        public void unregister() {
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    /* renamed from: b.b.a.a.a$d */
    public static final class d extends AppCompatDialog {
        public d(AddContentDialogFragment addContentDialogFragment, Context context, int i) {
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
    /* renamed from: b.b.a.a.a$e */
    public static final class e extends Lambda implements Function0<Unit> {
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
            FragmentManager childFragmentManager = AddContentDialogFragment.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            AddContentPagerAdapter4.a[] aVarArrM9292k = ((FlexInputFragment) this.$flexInputFragment).m9292k();
            AddContentPagerAdapter4 addContentPagerAdapter4 = new AddContentPagerAdapter4(childFragmentManager, (AddContentPagerAdapter4.a[]) Arrays.copyOf(aVarArrM9292k, aVarArrM9292k.length));
            AddContentDialogFragment addContentDialogFragment = AddContentDialogFragment.this;
            Objects.requireNonNull(addContentDialogFragment);
            Intrinsics3.checkNotNullParameter(addContentPagerAdapter4, "pagerAdapter");
            Context context = addContentDialogFragment.getContext();
            if (context != null && (tabLayout = addContentDialogFragment.contentTabs) != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                Intrinsics3.checkNotNullParameter(context, "context");
                Intrinsics3.checkNotNullParameter(tabLayout, "tabLayout");
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context, C11170R.c.tab_color_selector);
                int tabCount = tabLayout.getTabCount();
                for (int i = 0; i < tabCount; i++) {
                    TabLayout.Tab tabAt2 = tabLayout.getTabAt(i);
                    if (tabAt2 != null) {
                        Intrinsics3.checkNotNullExpressionValue(colorStateList, "iconColors");
                        Drawable icon = tabAt2.getIcon();
                        if (icon != null) {
                            Drawable drawableWrap = DrawableCompat.wrap(icon);
                            DrawableCompat.setTintList(drawableWrap, colorStateList);
                            tabAt2.setIcon(drawableWrap);
                        }
                    }
                }
                AddContentPagerAdapter4.a[] aVarArr = addContentPagerAdapter4.f2141a;
                ArrayList arrayList = new ArrayList(aVarArr.length);
                for (AddContentPagerAdapter4.a aVar : aVarArr) {
                    TabLayout.Tab icon2 = tabLayout.newTab().setIcon(aVar.getIcon());
                    Intrinsics3.checkNotNullExpressionValue(icon2, "tabLayout.newTab()\n              .setIcon(it.icon)");
                    Intrinsics3.checkNotNullExpressionValue(colorStateList, "iconColors");
                    Drawable icon3 = icon2.getIcon();
                    if (icon3 != null) {
                        Drawable drawableWrap2 = DrawableCompat.wrap(icon3);
                        DrawableCompat.setTintList(drawableWrap2, colorStateList);
                        icon2.setIcon(drawableWrap2);
                    }
                    arrayList.add(icon2.setContentDescription(aVar.getContentDesc()));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    tabLayout.addTab((TabLayout.Tab) it.next());
                }
                ViewPager viewPager = addContentDialogFragment.contentPager;
                if (viewPager != null) {
                    viewPager.setAdapter(addContentPagerAdapter4);
                }
                TabLayout tabLayout2 = addContentDialogFragment.contentTabs;
                if (tabLayout2 != null) {
                    tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new AddContentDialogFragment2(addContentDialogFragment));
                }
                ViewPager viewPager2 = addContentDialogFragment.contentPager;
                if (viewPager2 != null) {
                    viewPager2.addOnPageChangeListener(new AddContentDialogFragment3(addContentDialogFragment));
                }
                TabLayout tabLayout3 = addContentDialogFragment.contentTabs;
                if (tabLayout3 != null && (tabAt = tabLayout3.getTabAt(0)) != null) {
                    tabAt.select();
                }
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    /* renamed from: b.b.a.a.a$f */
    public static final class f extends AccessibilityDelegateCompat {
        public f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Intrinsics3.checkNotNullParameter(view, "host");
            Intrinsics3.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
            ImageView imageView = AddContentDialogFragment.this.launchButton;
            Objects.requireNonNull(imageView, "null cannot be cast to non-null type android.view.View");
            accessibilityNodeInfoCompat.setTraversalAfter(imageView);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        }
    }

    /* compiled from: AddContentDialogFragment.kt */
    /* renamed from: b.b.a.a.a$g */
    public static final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AddContentDialogFragment.m394g(AddContentDialogFragment.this);
        }
    }

    /* renamed from: g */
    public static final void m394g(AddContentDialogFragment addContentDialogFragment) {
        FloatingActionButton floatingActionButton = addContentDialogFragment.actionButton;
        if (floatingActionButton != null) {
            floatingActionButton.post(new AddContentDialogFragment4(addContentDialogFragment));
        }
    }

    /* renamed from: h */
    public final void m395h(boolean openKeyboard) throws Resources.NotFoundException {
        Context context = getContext();
        if (context == null) {
            dismissAllowingStateLoss();
            return;
        }
        Intrinsics3.checkNotNullExpressionValue(context, "context ?: return dismissAllowingStateLoss()");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, C10817R.anim.design_bottom_sheet_slide_out);
        Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "animation");
        animationLoadAnimation.setDuration(getResources().getInteger(C10817R.integer.bottom_sheet_slide_duration));
        animationLoadAnimation.setInterpolator(context, R.anim.accelerate_decelerate_interpolator);
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
        FlexInputCoordinator flexInputCoordinator = (FlexInputCoordinator) parentFragment;
        if (clipData == null) {
            Uri data = intentData.getData();
            if (data != null) {
                flexInputCoordinator.mo397f(Attachment.INSTANCE.m9296b(data, contentResolver));
                return;
            }
            return;
        }
        Ranges2 ranges2Until = _Ranges.until(0, clipData.getItemCount());
        ArrayList<Uri> arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it = ranges2Until.iterator();
        while (it.hasNext()) {
            ClipData.Item itemAt = clipData.getItemAt(((Iterators4) it).nextInt());
            Intrinsics3.checkNotNullExpressionValue(itemAt, "clipData.getItemAt(it)");
            arrayList.add(itemAt.getUri());
        }
        for (Uri uri : arrayList) {
            Attachment.Companion companion = Attachment.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(uri, "it");
            flexInputCoordinator.mo397f(companion.m9296b(uri, contentResolver));
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @SuppressLint({"PrivateResource"})
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        d dVar = new d(this, getContext(), C11170R.i.FlexInput_DialogWhenLarge);
        dVar.supportRequestWindowFeature(1);
        Window window = dVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(C10817R.style.Animation_AppCompat_Dialog);
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        return dVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C11170R.g.dialog_add_content_pager_with_fab, container, false);
        if (viewInflate != null) {
            viewInflate.setOnClickListener(new a(0, this));
            this.contentPager = (ViewPager) viewInflate.findViewById(C11170R.f.content_pager);
            this.contentTabs = (TabLayout) viewInflate.findViewById(C11170R.f.content_tabs);
            this.actionButton = (FloatingActionButton) viewInflate.findViewById(C11170R.f.action_btn);
            ImageView imageView = (ImageView) viewInflate.findViewById(C11170R.f.launch_btn);
            this.launchButton = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new a(1, this));
            }
            FloatingActionButton floatingActionButton = this.actionButton;
            Objects.requireNonNull(floatingActionButton, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
            floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(viewInflate.getContext(), C11170R.b.color_brand_500)));
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof FlexInputFragment) {
            FlexInputFragment flexInputFragment = (FlexInputFragment) parentFragment;
            e eVar = new e(parentFragment);
            Objects.requireNonNull(flexInputFragment);
            Intrinsics3.checkNotNullParameter(eVar, "onContentPagesInitialized");
            try {
                flexInputFragment.m9292k();
                eVar.invoke();
            } catch (UninitializedPropertyAccessException unused) {
                flexInputFragment.onContentPagesInitializedUpdates.add(eVar);
            }
            FloatingActionButton floatingActionButton2 = this.actionButton;
            if (floatingActionButton2 != null) {
                floatingActionButton2.setOnClickListener(new a(2, parentFragment));
            }
            this.selectionAggregator = flexInputFragment.mo396b().addItemSelectionListener(this.itemSelectionListener);
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
            Intrinsics3.checkNotNullExpressionValue(context, "it");
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, C10817R.anim.design_bottom_sheet_slide_in);
            Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "animation");
            animationLoadAnimation.setDuration(getResources().getInteger(C10817R.integer.bottom_sheet_slide_duration));
            animationLoadAnimation.setInterpolator(context, R.anim.accelerate_decelerate_interpolator);
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
        Intrinsics3.checkNotNullParameter(transaction, "transaction");
        transaction.setCustomAnimations(C10817R.anim.abc_grow_fade_in_from_bottom, C10817R.anim.abc_shrink_fade_out_from_bottom);
        return super.show(transaction, tag);
    }
}
