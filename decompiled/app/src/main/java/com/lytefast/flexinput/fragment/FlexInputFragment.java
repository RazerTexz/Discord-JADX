package com.lytefast.flexinput.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import b.b.a.a.g;
import b.b.a.a.h;
import b.b.a.a.i;
import b.b.a.a.j;
import b.b.a.a.l;
import b.b.a.a.p;
import b.b.a.d.d;
import b.b.a.h.a;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.R;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import com.lytefast.flexinput.viewmodel.FlexInputState;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.g0.w;
import d0.t.n;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* compiled from: FlexInputFragment.kt */
/* loaded from: classes3.dex */
public class FlexInputFragment extends Fragment implements b.b.a.b<Object> {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(FlexInputFragment.class, "binding", "getBinding()Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0)};
    public static final String k = FlexInputFragment.class.getName();

    /* renamed from: m, reason: from kotlin metadata */
    public FlexEditText inputEt;

    /* renamed from: n, reason: from kotlin metadata */
    public b.b.a.f.a keyboardManager;

    /* renamed from: o, reason: from kotlin metadata */
    public FlexInputListener inputListener;

    /* renamed from: p, reason: from kotlin metadata */
    public FileManager fileManager;

    /* renamed from: q, reason: from kotlin metadata */
    public AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter;
    public d.a[] r;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public FlexInputViewModel viewModel;

    /* renamed from: t, reason: from kotlin metadata */
    public Subscription stateSubscription;

    /* renamed from: u, reason: from kotlin metadata */
    public Subscription eventSubscription;

    /* renamed from: v, reason: from kotlin metadata */
    public Subscription showExpressionKeyboardSubscription;

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);

    /* renamed from: w, reason: from kotlin metadata */
    public final List<Function0<Unit>> onViewCreatedUpdates = new ArrayList();

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public List<Function0<Unit>> onContentPagesInitializedUpdates = new ArrayList();

    /* compiled from: java-style lambda group */
    /* loaded from: classes.dex */
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
                FlexInputViewModel flexInputViewModel = ((FlexInputFragment) this.k).viewModel;
                if (flexInputViewModel != null) {
                    flexInputViewModel.onInputTextClicked();
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = ((FlexInputFragment) this.k).attachmentPreviewAdapter;
            if (attachmentPreviewAdapter == null) {
                m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
            }
            attachmentPreviewAdapter.selectionAggregator.clear();
            attachmentPreviewAdapter.notifyDataSetChanged();
            FlexInputViewModel flexInputViewModel2 = ((FlexInputFragment) this.k).viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(n.emptyList());
            }
        }
    }

    /* compiled from: FlexInputFragment.kt */
    public static final class b implements Runnable {
        public final /* synthetic */ DialogFragment j;

        public b(DialogFragment dialogFragment) {
            this.j = dialogFragment;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DialogFragment dialogFragment = this.j;
            if (dialogFragment == null || !dialogFragment.isAdded() || this.j.isRemoving() || this.j.isDetached()) {
                return;
            }
            try {
                this.j.dismiss();
            } catch (IllegalStateException e) {
                Log.w(FlexInputFragment.k, "could not dismiss add content dialog", e);
            }
        }
    }

    /* compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class c extends k implements Function1<View, b.b.a.e.a> {
        public static final c j = new c();

        public c() {
            super(1, b.b.a.e.a.class, "bind", "bind(Landroid/view/View;)Lcom/lytefast/flexinput/databinding/FlexInputWidgetBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.b.a.e.a invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.f.attachment_clear_btn;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) view2.findViewById(i);
            if (appCompatImageButton != null) {
                i = R.f.attachment_preview_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(i);
                if (linearLayout != null) {
                    i = R.f.attachment_preview_list;
                    RecyclerView recyclerView = (RecyclerView) view2.findViewById(i);
                    if (recyclerView != null) {
                        i = R.f.cannot_send_text;
                        TextView textView = (TextView) view2.findViewById(i);
                        if (textView != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view2;
                            i = R.f.default_window_insets_handler;
                            FrameLayout frameLayout = (FrameLayout) view2.findViewById(i);
                            if (frameLayout != null) {
                                i = R.f.expand_btn;
                                AppCompatImageButton appCompatImageButton2 = (AppCompatImageButton) view2.findViewById(i);
                                if (appCompatImageButton2 != null) {
                                    i = R.f.expression_btn;
                                    AppCompatImageButton appCompatImageButton3 = (AppCompatImageButton) view2.findViewById(i);
                                    if (appCompatImageButton3 != null) {
                                        i = R.f.expression_btn_badge;
                                        ImageView imageView = (ImageView) view2.findViewById(i);
                                        if (imageView != null) {
                                            i = R.f.expression_btn_container;
                                            FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(i);
                                            if (frameLayout2 != null) {
                                                i = R.f.expression_tray_container;
                                                FrameLayout frameLayout3 = (FrameLayout) view2.findViewById(i);
                                                if (frameLayout3 != null) {
                                                    i = R.f.gallery_btn;
                                                    AppCompatImageButton appCompatImageButton4 = (AppCompatImageButton) view2.findViewById(i);
                                                    if (appCompatImageButton4 != null) {
                                                        i = R.f.gift_btn;
                                                        AppCompatImageButton appCompatImageButton5 = (AppCompatImageButton) view2.findViewById(i);
                                                        if (appCompatImageButton5 != null) {
                                                            i = R.f.left_btns_container;
                                                            LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(i);
                                                            if (linearLayout3 != null) {
                                                                i = R.f.main_input_container;
                                                                LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(i);
                                                                if (linearLayout4 != null) {
                                                                    i = R.f.send_btn_container;
                                                                    FrameLayout frameLayout4 = (FrameLayout) view2.findViewById(i);
                                                                    if (frameLayout4 != null) {
                                                                        i = R.f.send_btn_image;
                                                                        ImageView imageView2 = (ImageView) view2.findViewById(i);
                                                                        if (imageView2 != null) {
                                                                            i = R.f.text_input;
                                                                            FlexEditText flexEditText = (FlexEditText) view2.findViewById(i);
                                                                            if (flexEditText != null) {
                                                                                return new b.b.a.e.a(linearLayout2, appCompatImageButton, linearLayout, recyclerView, textView, linearLayout2, frameLayout, appCompatImageButton2, appCompatImageButton3, imageView, frameLayout2, frameLayout3, appCompatImageButton4, appCompatImageButton5, linearLayout3, linearLayout4, frameLayout4, imageView2, flexEditText);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    /* compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class d extends k implements Function1<FlexInputState, Unit> {
        public d(FlexInputFragment flexInputFragment) {
            super(1, flexInputFragment, FlexInputFragment.class, "configureUI", "configureUI(Lcom/lytefast/flexinput/viewmodel/FlexInputState;)V", 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
        @Override // kotlin.jvm.functions.Function1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Unit invoke(FlexInputState flexInputState) {
            FlexInputState flexInputState2 = flexInputState;
            m.checkNotNullParameter(flexInputState2, "p1");
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
            KProperty[] kPropertyArr = FlexInputFragment.j;
            Objects.requireNonNull(flexInputFragment);
            j jVar = new j(flexInputFragment);
            b.b.a.a.k kVar = new b.b.a.a.k(flexInputFragment);
            l lVar = new l(flexInputFragment);
            if (flexInputFragment.m()) {
                if (flexInputFragment.inputEt == null) {
                    m.throwUninitializedPropertyAccessException("inputEt");
                }
                if (!m.areEqual(r4.getEditableText().toString(), flexInputState2.inputText)) {
                    FlexEditText flexEditText = flexInputFragment.inputEt;
                    if (flexEditText == null) {
                        m.throwUninitializedPropertyAccessException("inputEt");
                    }
                    flexEditText.setText(flexInputState2.inputText);
                    FlexEditText flexEditText2 = flexInputFragment.inputEt;
                    if (flexEditText2 == null) {
                        m.throwUninitializedPropertyAccessException("inputEt");
                    }
                    flexEditText2.setSelection(flexInputState2.inputText.length());
                }
                boolean z2 = flexInputState2.showExpandedButtons;
                AppCompatImageButton appCompatImageButton = flexInputFragment.j().h;
                m.checkNotNullExpressionValue(appCompatImageButton, "binding.expandBtn");
                appCompatImageButton.setVisibility(!z2 ? 0 : 8);
                AppCompatImageButton appCompatImageButton2 = flexInputFragment.j().m;
                m.checkNotNullExpressionValue(appCompatImageButton2, "binding.giftBtn");
                appCompatImageButton2.setVisibility(z2 ? 0 : 8);
                AppCompatImageButton appCompatImageButton3 = flexInputFragment.j().l;
                m.checkNotNullExpressionValue(appCompatImageButton3, "binding.galleryBtn");
                appCompatImageButton3.setVisibility(z2 ? 0 : 8);
                if (flexInputState2.ableToSendMessages) {
                    String str = flexInputState2.inputText;
                    Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                    boolean z3 = (w.trim(str).toString().length() > 0) || flexInputState2.attachments.size() > 0;
                    ImageView imageView = flexInputFragment.j().p;
                    m.checkNotNullExpressionValue(imageView, "binding.sendBtnImage");
                    imageView.setEnabled(z3);
                    FrameLayout frameLayout = flexInputFragment.j().o;
                    m.checkNotNullExpressionValue(frameLayout, "binding.sendBtnContainer");
                    frameLayout.setEnabled(z3);
                    boolean z4 = (flexInputState2.inputText.length() > 0) || flexInputState2.attachments.size() > 0;
                    FrameLayout frameLayout2 = flexInputFragment.j().o;
                    m.checkNotNullExpressionValue(frameLayout2, "binding.sendBtnContainer");
                    frameLayout2.setVisibility(z4 ? 0 : 8);
                    LinearLayout linearLayout = flexInputFragment.j().n;
                    m.checkNotNullExpressionValue(linearLayout, "binding.mainInputContainer");
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.rightMargin = !z4 ? DimenUtils.dpToPixels(8) : 0;
                    LinearLayout linearLayout2 = flexInputFragment.j().n;
                    m.checkNotNullExpressionValue(linearLayout2, "binding.mainInputContainer");
                    linearLayout2.setLayoutParams(layoutParams2);
                    if (flexInputState2.attachments.isEmpty()) {
                        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = flexInputFragment.attachmentPreviewAdapter;
                        if (attachmentPreviewAdapter == null) {
                            m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
                        }
                        attachmentPreviewAdapter.selectionAggregator.clear();
                        attachmentPreviewAdapter.notifyDataSetChanged();
                    }
                    LinearLayout linearLayout3 = flexInputFragment.j().c;
                    m.checkNotNullExpressionValue(linearLayout3, "binding.attachmentPreviewContainer");
                    linearLayout3.setVisibility((flexInputState2.attachments.size() > 0 && flexInputState2.ableToSendMessages && flexInputState2.attachmentViewEnabled) ? 0 : 8);
                    AppCompatImageButton appCompatImageButton4 = flexInputFragment.j().l;
                    m.checkNotNullExpressionValue(appCompatImageButton4, "binding.galleryBtn");
                    ViewExtensions.setEnabledAlpha$default(appCompatImageButton4, flexInputState2.ableToSendMessages && flexInputState2.ableToAttachFiles, 0.0f, 2, null);
                    b.b.a.a.a aVar = (b.b.a.a.a) flexInputFragment.getChildFragmentManager().findFragmentByTag("Add Content");
                    Integer num = flexInputState2.showContentDialogIndex;
                    if (num != null) {
                        if (aVar == null) {
                            try {
                                FlexInputFragment.g(jVar.this$0, num.intValue());
                            } catch (Exception e) {
                                Log.d(FlexInputFragment.k, "Could not open AddContentDialogFragment", e);
                            }
                        } else {
                            int iIntValue = num.intValue();
                            ViewPager viewPager = aVar.contentPager;
                            if (viewPager != null) {
                                viewPager.setCurrentItem(iIntValue);
                            }
                        }
                    } else if (aVar != null && aVar.isAdded() && !aVar.isDetached()) {
                        aVar.dismissAllowingStateLoss();
                    }
                    TextView textView = flexInputFragment.j().e;
                    m.checkNotNullExpressionValue(textView, "binding.cannotSendText");
                    textView.setVisibility(flexInputState2.ableToSendMessages ? 8 : 0);
                    if (flexInputState2.showExpressionTray) {
                        lVar.invoke2();
                    } else {
                        kVar.invoke(flexInputState2.showExpressionTrayButtonBadge);
                    }
                }
            }
            return Unit.a;
        }
    }

    /* compiled from: FlexInputFragment.kt */
    public static final /* synthetic */ class e extends k implements Function1<b.b.a.h.a, Unit> {
        public e(FlexInputFragment flexInputFragment) {
            super(1, flexInputFragment, FlexInputFragment.class, "handleEvent", "handleEvent(Lcom/lytefast/flexinput/viewmodel/FlexInputEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(b.b.a.h.a aVar) {
            b.b.a.h.a aVar2 = aVar;
            m.checkNotNullParameter(aVar2, "p1");
            FlexInputFragment flexInputFragment = (FlexInputFragment) this.receiver;
            KProperty[] kPropertyArr = FlexInputFragment.j;
            Objects.requireNonNull(flexInputFragment);
            if (aVar2 instanceof a.d) {
                Toast.makeText(flexInputFragment.requireContext(), ((a.d) aVar2).a, 0).show();
            } else if (aVar2 instanceof a.e) {
                Toast.makeText(flexInputFragment.requireContext(), ((a.e) aVar2).a, 0).show();
            } else if (aVar2 instanceof a.c) {
                b.b.a.f.a aVar3 = flexInputFragment.keyboardManager;
                if (aVar3 != null) {
                    FlexEditText flexEditText = flexInputFragment.inputEt;
                    if (flexEditText == null) {
                        m.throwUninitializedPropertyAccessException("inputEt");
                    }
                    aVar3.requestDisplay(flexEditText);
                }
            } else if (aVar2 instanceof a.b) {
                b.b.a.f.a aVar4 = flexInputFragment.keyboardManager;
                if (aVar4 != null) {
                    aVar4.requestHide();
                }
            } else if (aVar2 instanceof a.C0060a) {
                flexInputFragment.j().q.performClick();
            }
            return Unit.a;
        }
    }

    /* compiled from: FlexInputFragment.kt */
    public static final class f extends o implements Function1<Editable, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Editable editable) {
            Editable editable2 = editable;
            m.checkNotNullParameter(editable2, "it");
            FlexInputViewModel flexInputViewModel = FlexInputFragment.this.viewModel;
            if (flexInputViewModel != null) {
                b.i.a.f.e.o.f.P0(flexInputViewModel, editable2.toString(), null, 2, null);
            }
            return Unit.a;
        }
    }

    public static final void g(FlexInputFragment flexInputFragment, int i) {
        ViewPager viewPager;
        FragmentTransaction fragmentTransactionBeginTransaction = flexInputFragment.getChildFragmentManager().beginTransaction();
        m.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "childFragmentManager.beginTransaction()");
        b.b.a.a.a aVar = new b.b.a.a.a();
        aVar.show(fragmentTransactionBeginTransaction, "Add Content");
        flexInputFragment.getChildFragmentManager().executePendingTransactions();
        if (aVar.getDialog() == null) {
            return;
        }
        ViewPager viewPager2 = aVar.contentPager;
        if (viewPager2 != null) {
            viewPager2.setCurrentItem(i);
        }
        FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onContentDialogPageChanged(i);
        }
        b.b.a.a.f fVar = new b.b.a.a.f(flexInputFragment);
        m.checkNotNullParameter(fVar, "listener");
        ViewPager.OnPageChangeListener onPageChangeListener = aVar.onPageChangeListener;
        if (onPageChangeListener != null && (viewPager = aVar.contentPager) != null) {
            viewPager.removeOnPageChangeListener(onPageChangeListener);
        }
        aVar.onPageChangeListener = fVar;
        ViewPager viewPager3 = aVar.contentPager;
        if (viewPager3 != null) {
            viewPager3.addOnPageChangeListener(fVar);
        }
        Dialog dialog = aVar.getDialog();
        if (dialog != null) {
            dialog.setOnDismissListener(new g(flexInputFragment));
        }
        h hVar = new h(flexInputFragment);
        m.checkNotNullParameter(hVar, "onKeyboardSelectedListener");
        aVar.onKeyboardSelectedListener = hVar;
    }

    public static final void h(FlexInputFragment flexInputFragment, boolean z2) {
        Fragment fragmentFindFragmentById = flexInputFragment.getChildFragmentManager().findFragmentById(R.f.expression_tray_container);
        if (fragmentFindFragmentById != null && fragmentFindFragmentById.isAdded() && fragmentFindFragmentById.isResumed()) {
            boolean z3 = fragmentFindFragmentById instanceof b.b.a.c;
            Object obj = fragmentFindFragmentById;
            if (!z3) {
                obj = null;
            }
            b.b.a.c cVar = (b.b.a.c) obj;
            if (cVar != null) {
                cVar.isShown(z2);
            }
        }
    }

    @Override // b.b.a.b
    public SelectionAggregator<Attachment<Object>> b() {
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = this.attachmentPreviewAdapter;
        if (attachmentPreviewAdapter == null) {
            m.throwUninitializedPropertyAccessException("attachmentPreviewAdapter");
        }
        return attachmentPreviewAdapter.selectionAggregator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.b.a.b
    public void f(Attachment<? extends Object> attachment) {
        m.checkNotNullParameter(attachment, "attachment");
        DialogFragment dialogFragment = (DialogFragment) getChildFragmentManager().findFragmentByTag("Add Content");
        SelectionCoordinator<T, ?> selectionCoordinator = new SelectionCoordinator<>(null, null, 3);
        b().registerSelectionCoordinator(selectionCoordinator);
        selectionCoordinator.c(attachment, 0);
        selectionCoordinator.itemSelectionListener.unregister();
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onAttachmentsUpdated(b().getAttachments());
        }
        j().d.post(new b(dialogFragment));
    }

    @Override // b.b.a.b
    public FileManager getFileManager() {
        FileManager fileManager = this.fileManager;
        if (fileManager == null) {
            m.throwUninitializedPropertyAccessException("fileManager");
        }
        return fileManager;
    }

    @Override // b.b.a.b
    public boolean hasMediaPermissions() {
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            return flexInputViewModel.hasMediaPermissions();
        }
        return false;
    }

    public final void i(Function0<Unit> onViewCreatedUpdate) {
        m.checkNotNullParameter(onViewCreatedUpdate, "onViewCreatedUpdate");
        try {
            LinearLayout linearLayout = j().f;
            onViewCreatedUpdate.invoke();
        } catch (IllegalStateException unused) {
            this.onViewCreatedUpdates.add(onViewCreatedUpdate);
        }
    }

    public final b.b.a.e.a j() {
        return (b.b.a.e.a) this.binding.getValue((Fragment) this, j[0]);
    }

    public final d.a[] k() {
        d.a[] aVarArr = this.r;
        if (aVarArr == null) {
            m.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        if (aVarArr.length == 0) {
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            m.checkNotNullParameter(contextRequireContext, "context");
            return new d.a[]{new b.b.a.d.a(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.b.ic_flex_input_image, 0, 2, (Object) null), R.h.attachment_media), new b.b.a.d.b(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.b.ic_flex_input_file, 0, 2, (Object) null), R.h.attachment_files), new b.b.a.d.c(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R.b.ic_flex_input_add_a_photo, 0, 2, (Object) null), R.h.camera)};
        }
        d.a[] aVarArr2 = this.r;
        if (aVarArr2 == null) {
            m.throwUninitializedPropertyAccessException("pageSuppliers");
        }
        return aVarArr2;
    }

    public final FlexEditText l() {
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        return flexEditText;
    }

    public final boolean m() {
        View view;
        if (!isAdded() || isHidden() || (view = getView()) == null) {
            return false;
        }
        return view.getVisibility() == 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.g.flex_input_widget, container, false);
        View viewFindViewById = viewInflate.findViewById(R.f.text_input);
        m.checkNotNullExpressionValue(viewFindViewById, "root.findViewById(R.id.text_input)");
        this.inputEt = (FlexEditText) viewFindViewById;
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TextWatcher.INSTANCE.reset(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onFlexInputFragmentPause();
        }
        Subscription subscription = this.stateSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.eventSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        Subscription subscription3 = this.showExpressionKeyboardSubscription;
        if (subscription3 != null) {
            subscription3.unsubscribe();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            this.stateSubscription = flexInputViewModel.observeState().r().V(new b.b.a.a.n(new d(this)));
            FlexInputViewModel flexInputViewModel2 = this.viewModel;
            if (flexInputViewModel2 != null) {
                this.eventSubscription = flexInputViewModel2.observeEvents().V(new b.b.a.a.n(new e(this)));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        m.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("FlexInput.ATTACHMENTS", b().getAttachments());
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        outState.putString("FlexInput.TEXT", String.valueOf(flexEditText.getText()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FlexInputViewModel flexInputViewModel;
        m.checkNotNullParameter(view, "view");
        AttachmentPreviewAdapter<Attachment<Object>> attachmentPreviewAdapter = new AttachmentPreviewAdapter<>(false, null, null, 7);
        attachmentPreviewAdapter.selectionAggregator.addItemSelectionListener(new b.b.a.a.m(this));
        this.attachmentPreviewAdapter = attachmentPreviewAdapter;
        FlexEditText flexEditText = this.inputEt;
        if (flexEditText == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        TextWatcherKt.addBindedTextWatcher(flexEditText, this, new f());
        FlexEditText flexEditText2 = this.inputEt;
        if (flexEditText2 == null) {
            m.throwUninitializedPropertyAccessException("inputEt");
        }
        flexEditText2.setOnClickListener(new a(0, this));
        j().f322b.setOnClickListener(new a(1, this));
        b.b.a.e.a aVarJ = j();
        j().i.setOnClickListener(new defpackage.h(0, this));
        j().o.setOnClickListener(new defpackage.h(1, this));
        aVarJ.l.setOnClickListener(new defpackage.h(2, this));
        aVarJ.m.setOnClickListener(new defpackage.h(3, this));
        aVarJ.h.setOnClickListener(new defpackage.h(4, this));
        AppCompatImageButton appCompatImageButton = aVarJ.f322b;
        m.checkNotNullExpressionValue(appCompatImageButton, "attachmentClearBtn");
        AppCompatImageButton appCompatImageButton2 = aVarJ.l;
        m.checkNotNullExpressionValue(appCompatImageButton2, "galleryBtn");
        AppCompatImageButton appCompatImageButton3 = aVarJ.m;
        m.checkNotNullExpressionValue(appCompatImageButton3, "giftBtn");
        AppCompatImageButton appCompatImageButton4 = aVarJ.i;
        m.checkNotNullExpressionValue(appCompatImageButton4, "expressionBtn");
        FrameLayout frameLayout = aVarJ.o;
        m.checkNotNullExpressionValue(frameLayout, "sendBtnContainer");
        AppCompatImageButton appCompatImageButton5 = aVarJ.h;
        m.checkNotNullExpressionValue(appCompatImageButton5, "expandBtn");
        Iterator it = n.listOf((Object[]) new View[]{appCompatImageButton, appCompatImageButton2, appCompatImageButton3, appCompatImageButton4, frameLayout, appCompatImageButton5}).iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnLongClickListener(new i(this));
        }
        FrameLayout frameLayout2 = j().k;
        m.checkNotNullExpressionValue(frameLayout2, "binding.expressionTrayContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        FrameLayout frameLayout3 = j().k;
        m.checkNotNullExpressionValue(frameLayout3, "binding.expressionTrayContainer");
        m.checkNotNullExpressionValue(frameLayout3.getContext(), "binding.expressionTrayContainer.context");
        layoutParams2.height = (int) (DisplayUtils.getScreenSize(r2).height() * 0.5f);
        FrameLayout frameLayout4 = j().k;
        m.checkNotNullExpressionValue(frameLayout4, "binding.expressionTrayContainer");
        frameLayout4.setLayoutParams(layoutParams2);
        if (savedInstanceState != null) {
            ArrayList<? super Parcelable> parcelableArrayList = savedInstanceState.getParcelableArrayList("FlexInput.ATTACHMENTS");
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                b().initFrom(parcelableArrayList);
            }
            FlexInputViewModel flexInputViewModel2 = this.viewModel;
            if (flexInputViewModel2 != null) {
                flexInputViewModel2.onAttachmentsUpdated(b().getAttachments());
            }
            String string = savedInstanceState.getString("FlexInput.TEXT");
            if (string != null && (flexInputViewModel = this.viewModel) != null) {
                flexInputViewModel.onInputTextChanged(string, null);
            }
        }
        FrameLayout frameLayout5 = j().k;
        m.checkNotNullExpressionValue(frameLayout5, "binding.expressionTrayContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout5);
        ViewCompat.setOnApplyWindowInsetsListener(j().g, b.b.a.a.o.a);
        ViewCompat.setOnApplyWindowInsetsListener(j().f, new p(this));
        Iterator<Function0<Unit>> it2 = this.onViewCreatedUpdates.iterator();
        while (it2.hasNext()) {
            it2.next().invoke();
        }
        this.onViewCreatedUpdates.clear();
    }

    @Override // b.b.a.b
    public void requestMediaPermissions(Function0<Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        FlexInputViewModel flexInputViewModel = this.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.requestMediaPermissions(onSuccess);
        }
    }
}
