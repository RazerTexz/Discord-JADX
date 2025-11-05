package com.discord.widgets.user;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserSetCustomStatusBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.RadioManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.user.WidgetUserSetCustomStatusViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetUserSetCustomStatus.kt */
/* loaded from: classes.dex */
public final class WidgetUserSetCustomStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserSetCustomStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserSetCustomStatusBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String currentEmojiUri;
    private RadioManager expirationRadioManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetUserSetCustomStatus.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetUserSetCustomStatus.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetUserSetCustomStatusViewModel.FormState.Expiration.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.NEVER.ordinal()] = 1;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_30_MINUTES.ordinal()] = 2;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_1_HOUR.ordinal()] = 3;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_4_HOURS.ordinal()] = 4;
            iArr[WidgetUserSetCustomStatusViewModel.FormState.Expiration.TOMORROW.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$openEmojiPicker(WidgetUserSetCustomStatus.this);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).clearStatusTextAndEmoji();
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Editable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            m.checkNotNullParameter(editable, "editable");
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).setStatusText(editable.toString());
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).saveStatus();
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetUserSetCustomStatusViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
            super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetUserSetCustomStatus.access$updateView((WidgetUserSetCustomStatus) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<WidgetUserSetCustomStatusViewModel.Event, Unit> {
        public AnonymousClass2(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
            super(1, widgetUserSetCustomStatus, WidgetUserSetCustomStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/WidgetUserSetCustomStatusViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSetCustomStatusViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserSetCustomStatusViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetUserSetCustomStatus.access$handleEvent((WidgetUserSetCustomStatus) this.receiver, event);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$openEmojiPicker$1, reason: invalid class name */
    public static final class AnonymousClass1 implements EmojiPickerListener {
        public AnonymousClass1() {
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
        public void onEmojiPicked(Emoji emoji) {
            m.checkNotNullParameter(emoji, "emoji");
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).setStatusEmoji(emoji);
        }
    }

    /* compiled from: WidgetUserSetCustomStatus.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserSetCustomStatus$setExpirationOnCheck$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetUserSetCustomStatusViewModel.FormState.Expiration $expiration;

        public AnonymousClass1(WidgetUserSetCustomStatusViewModel.FormState.Expiration expiration) {
            this.$expiration = expiration;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserSetCustomStatus.access$getViewModel$p(WidgetUserSetCustomStatus.this).setExpiration(this.$expiration);
        }
    }

    public WidgetUserSetCustomStatus() {
        super(R.layout.widget_user_set_custom_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserSetCustomStatus$binding$2.INSTANCE, null, 2, null);
        WidgetUserSetCustomStatus$viewModel$2 widgetUserSetCustomStatus$viewModel$2 = WidgetUserSetCustomStatus$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetUserSetCustomStatusViewModel.class), new WidgetUserSetCustomStatus$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetUserSetCustomStatus$viewModel$2));
    }

    public static final /* synthetic */ WidgetUserSetCustomStatusViewModel access$getViewModel$p(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        return widgetUserSetCustomStatus.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetUserSetCustomStatus widgetUserSetCustomStatus, WidgetUserSetCustomStatusViewModel.Event event) {
        widgetUserSetCustomStatus.handleEvent(event);
    }

    public static final /* synthetic */ void access$openEmojiPicker(WidgetUserSetCustomStatus widgetUserSetCustomStatus) {
        widgetUserSetCustomStatus.openEmojiPicker();
    }

    public static final /* synthetic */ void access$updateView(WidgetUserSetCustomStatus widgetUserSetCustomStatus, WidgetUserSetCustomStatusViewModel.ViewState viewState) {
        widgetUserSetCustomStatus.updateView(viewState);
    }

    private final WidgetUserSetCustomStatusBinding getBinding() {
        return (WidgetUserSetCustomStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserSetCustomStatusViewModel getViewModel() {
        return (WidgetUserSetCustomStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetUserSetCustomStatusViewModel.Event event) {
        if (!(event instanceof WidgetUserSetCustomStatusViewModel.Event.SetStatusSuccess)) {
            if (event instanceof WidgetUserSetCustomStatusViewModel.Event.SetStatusFailure) {
                b.a.d.m.i(this, ((WidgetUserSetCustomStatusViewModel.Event.SetStatusFailure) event).getFailureMessageStringRes(), 0, 4);
            }
        } else {
            b.a.d.m.i(this, ((WidgetUserSetCustomStatusViewModel.Event.SetStatusSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void openEmojiPicker() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet$default(parentFragmentManager, new AnonymousClass1(), EmojiPickerContextType.Global.INSTANCE, null, 8, null);
    }

    private final void setExpirationOnCheck(MaterialRadioButton materialRadioButton, WidgetUserSetCustomStatusViewModel.FormState.Expiration expiration) {
        materialRadioButton.setOnClickListener(new AnonymousClass1(expiration));
    }

    private final void updateView(WidgetUserSetCustomStatusViewModel.ViewState viewState) {
        MaterialRadioButton materialRadioButton;
        if (viewState instanceof WidgetUserSetCustomStatusViewModel.ViewState.Loaded) {
            WidgetUserSetCustomStatusViewModel.ViewState.Loaded loaded = (WidgetUserSetCustomStatusViewModel.ViewState.Loaded) viewState;
            WidgetUserSetCustomStatusViewModel.FormState formState = loaded.getFormState();
            if (formState.getEmoji() != null) {
                String imageUri = formState.getEmoji().getImageUri(true, IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.custom_status_emoji_preview_size)), getContext());
                if (!m.areEqual(imageUri, this.currentEmojiUri)) {
                    SimpleDraweeView simpleDraweeView = getBinding().f2692b;
                    m.checkNotNullExpressionValue(simpleDraweeView, "binding.setCustomStatusEmoji");
                    MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
                    this.currentEmojiUri = imageUri;
                }
            } else {
                getBinding().f2692b.setActualImageResource(R.drawable.ic_smiley_desaturated);
                this.currentEmojiUri = null;
            }
            TextInputLayout textInputLayout = getBinding().j;
            m.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            if (!m.areEqual(formState.getText(), textOrEmpty)) {
                TextInputLayout textInputLayout2 = getBinding().j;
                m.checkNotNullExpressionValue(textInputLayout2, "binding.setCustomStatusText");
                ViewExtensions.setText(textInputLayout2, formState.getText());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout3 = getBinding().j;
                    m.checkNotNullExpressionValue(textInputLayout3, "binding.setCustomStatusText");
                    EditText editText = textInputLayout3.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout4 = getBinding().j;
                    m.checkNotNullExpressionValue(textInputLayout4, "binding.setCustomStatusText");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout4).length());
                }
            }
            TextInputLayout textInputLayout5 = getBinding().j;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.setCustomStatusText");
            textInputLayout5.setEndIconVisible(loaded.getShowStatusClear());
            int iOrdinal = formState.getExpiration().ordinal();
            if (iOrdinal == 0) {
                materialRadioButton = getBinding().g;
            } else if (iOrdinal == 1) {
                materialRadioButton = getBinding().e;
            } else if (iOrdinal == 2) {
                materialRadioButton = getBinding().d;
            } else if (iOrdinal == 3) {
                materialRadioButton = getBinding().f;
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                materialRadioButton = getBinding().h;
            }
            m.checkNotNullExpressionValue(materialRadioButton, "when (formState.expirati…sExpirationTomorrow\n    }");
            RadioManager radioManager = this.expirationRadioManager;
            if (radioManager == null) {
                m.throwUninitializedPropertyAccessException("expirationRadioManager");
            }
            radioManager.a(materialRadioButton);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) throws Resources.NotFoundException {
        Window window;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null && (window = appActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.custom_status);
        this.expirationRadioManager = new RadioManager(n.listOf((Object[]) new MaterialRadioButton[]{getBinding().g, getBinding().e, getBinding().d, getBinding().f, getBinding().h}));
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().j.setEndIconOnClickListener(new AnonymousClass2());
        TextInputLayout textInputLayout = getBinding().j;
        m.checkNotNullExpressionValue(textInputLayout, "binding.setCustomStatusText");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass3());
        MaterialRadioButton materialRadioButton = getBinding().g;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.setCustomStatusExpirationNever");
        setExpirationOnCheck(materialRadioButton, WidgetUserSetCustomStatusViewModel.FormState.Expiration.NEVER);
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R.plurals.custom_status_clear_in_minutes_minutes, 30, 30);
        MaterialRadioButton materialRadioButton2 = getBinding().e;
        m.checkNotNullExpressionValue(materialRadioButton2, "binding.setCustomStatusExpiration30Minutes");
        materialRadioButton2.setText(b.k(this, R.string.custom_status_clear_in_minutes, new Object[]{quantityString}, null, 4));
        MaterialRadioButton materialRadioButton3 = getBinding().e;
        m.checkNotNullExpressionValue(materialRadioButton3, "binding.setCustomStatusExpiration30Minutes");
        setExpirationOnCheck(materialRadioButton3, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_30_MINUTES);
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        CharSequence quantityString2 = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R.plurals.custom_status_clear_in_hours_hours, 1, 1);
        MaterialRadioButton materialRadioButton4 = getBinding().d;
        m.checkNotNullExpressionValue(materialRadioButton4, "binding.setCustomStatusExpiration1Hour");
        materialRadioButton4.setText(b.k(this, R.string.custom_status_clear_in_hours, new Object[]{quantityString2}, null, 4));
        MaterialRadioButton materialRadioButton5 = getBinding().d;
        m.checkNotNullExpressionValue(materialRadioButton5, "binding.setCustomStatusExpiration1Hour");
        setExpirationOnCheck(materialRadioButton5, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_1_HOUR);
        Resources resources3 = getResources();
        m.checkNotNullExpressionValue(resources3, "resources");
        CharSequence quantityString3 = StringResourceUtilsKt.getQuantityString(resources3, requireContext(), R.plurals.custom_status_clear_in_hours_hours, 4, 4);
        MaterialRadioButton materialRadioButton6 = getBinding().f;
        m.checkNotNullExpressionValue(materialRadioButton6, "binding.setCustomStatusExpiration4Hours");
        materialRadioButton6.setText(b.k(this, R.string.custom_status_clear_in_hours, new Object[]{quantityString3}, null, 4));
        MaterialRadioButton materialRadioButton7 = getBinding().f;
        m.checkNotNullExpressionValue(materialRadioButton7, "binding.setCustomStatusExpiration4Hours");
        setExpirationOnCheck(materialRadioButton7, WidgetUserSetCustomStatusViewModel.FormState.Expiration.IN_4_HOURS);
        MaterialRadioButton materialRadioButton8 = getBinding().h;
        m.checkNotNullExpressionValue(materialRadioButton8, "binding.setCustomStatusExpirationTomorrow");
        setExpirationOnCheck(materialRadioButton8, WidgetUserSetCustomStatusViewModel.FormState.Expiration.TOMORROW);
        getBinding().i.setOnClickListener(new AnonymousClass4());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserSetCustomStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetUserSetCustomStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
