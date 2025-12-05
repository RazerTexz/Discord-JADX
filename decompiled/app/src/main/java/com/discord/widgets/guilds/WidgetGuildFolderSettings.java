package com.discord.widgets.guilds;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p007b.p440k.p441a.p442a.ColorPickerDialogListener;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p600f0.p601e0.Util7;
import p658rx.Observable;

/* compiled from: WidgetGuildFolderSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildFolderSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildFolderSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildFolderSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long folderId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m156d(context, WidgetGuildFolderSettings.class, new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$1 */
    public static final class C85721 extends Lambda implements Function1<Editable, Unit> {
        public C85721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).setName(editable.toString());
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$2 */
    public static final class ViewOnClickListenerC85732 implements View.OnClickListener {
        public final /* synthetic */ WidgetGuildFolderSettingsViewModel.ViewState $state;

        public ViewOnClickListenerC85732(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            this.$state = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildFolderSettings.access$launchColorPicker(WidgetGuildFolderSettings.this, (WidgetGuildFolderSettingsViewModel.ViewState.Loaded) this.$state);
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$3 */
    public static final class ViewOnClickListenerC85743 implements View.OnClickListener {
        public ViewOnClickListenerC85743() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).saveFolder();
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$launchColorPicker$1 */
    public static final class C85751 implements ColorPickerDialogListener {
        public C85751() {
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onColorReset(int dialogId) {
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).setColor(Integer.valueOf(WidgetGuildFolderSettings.access$argbColorToRGB(WidgetGuildFolderSettings.this, ColorCompat.getThemedColor(WidgetGuildFolderSettings.this.getContext(), C5419R.attr.color_brand))));
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onColorSelected(int dialogId, int selectedColor) {
            WidgetGuildFolderSettings.access$getViewModel$p(WidgetGuildFolderSettings.this).setColor(Integer.valueOf(WidgetGuildFolderSettings.access$argbColorToRGB(WidgetGuildFolderSettings.this, selectedColor)));
        }

        @Override // p007b.p440k.p441a.p442a.ColorPickerDialogListener
        public void onDialogDismissed(int dialogId) {
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C85761 extends FunctionReferenceImpl implements Function1<WidgetGuildFolderSettingsViewModel.ViewState, Unit> {
        public C85761(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildFolderSettings.access$configureUI((WidgetGuildFolderSettings) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildFolderSettings.kt */
    /* renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$2 */
    public static final /* synthetic */ class C85772 extends FunctionReferenceImpl implements Function1<WidgetGuildFolderSettingsViewModel.Event, Unit> {
        public C85772(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildFolderSettings.access$handleEvent((WidgetGuildFolderSettings) this.receiver, event);
        }
    }

    public WidgetGuildFolderSettings() {
        super(C5419R.layout.widget_guild_folder_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildFolderSettings2.INSTANCE, null, 2, null);
        WidgetGuildFolderSettings3 widgetGuildFolderSettings3 = new WidgetGuildFolderSettings3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildFolderSettingsViewModel.class), new WidgetGuildFolderSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildFolderSettings3));
    }

    public static final /* synthetic */ int access$argbColorToRGB(WidgetGuildFolderSettings widgetGuildFolderSettings, int i) {
        return widgetGuildFolderSettings.argbColorToRGB(i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel.ViewState viewState) {
        widgetGuildFolderSettings.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetGuildFolderSettingsViewModel access$getViewModel$p(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        return widgetGuildFolderSettings.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel.Event event) {
        widgetGuildFolderSettings.handleEvent(event);
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel.ViewState.Loaded loaded) {
        widgetGuildFolderSettings.launchColorPicker(loaded);
    }

    private final int argbColorToRGB(int color) {
        return Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
    }

    private final void configureUI(WidgetGuildFolderSettingsViewModel.ViewState state) {
        int themedColor;
        if (state instanceof WidgetGuildFolderSettingsViewModel.ViewState.Loaded) {
            View view = getBinding().f16778e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.guildFolderSettingsColorDisplay");
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), C5419R.drawable.drawable_circle_white_1);
            WidgetGuildFolderSettingsViewModel.ViewState.Loaded loaded = (WidgetGuildFolderSettingsViewModel.ViewState.Loaded) state;
            Integer numRgbColorToARGB = rgbColorToARGB(loaded.getFormState().getColor());
            if (numRgbColorToARGB != null) {
                themedColor = numRgbColorToARGB.intValue();
            } else {
                View view2 = getBinding().f16778e;
                Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildFolderSettingsColorDisplay");
                themedColor = ColorCompat.getThemedColor(view2, C5419R.attr.color_brand);
            }
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP));
                View view3 = getBinding().f16778e;
                Intrinsics3.checkNotNullExpressionValue(view3, "binding.guildFolderSettingsColorDisplay");
                view3.setBackground(drawable);
            }
            TextInputLayout textInputLayout = getBinding().f16775b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editGuildFolderName");
            ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C85721());
            TextInputLayout textInputLayout2 = getBinding().f16775b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editGuildFolderName");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
            if (!Intrinsics3.areEqual(loaded.getFormState().getName(), textOrEmpty)) {
                TextInputLayout textInputLayout3 = getBinding().f16775b;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editGuildFolderName");
                ViewExtensions.setText(textInputLayout3, loaded.getFormState().getName());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout4 = getBinding().f16775b;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editGuildFolderName");
                    EditText editText = textInputLayout4.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout5 = getBinding().f16775b;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.editGuildFolderName");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout5).length());
                }
            }
            TextView textView = getBinding().f16776c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildFolderColorName");
            StringBuilder sb = new StringBuilder();
            sb.append(MentionUtils.CHANNELS_CHAR);
            String strM10143x = Util7.m10143x(themedColor);
            Objects.requireNonNull(strM10143x, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strM10143x.substring(2);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
            textView.setText(sb.toString());
            getBinding().f16777d.setOnClickListener(new ViewOnClickListenerC85732(state));
            FloatingActionButton floatingActionButton = getBinding().f16779f;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.guildFolderSettingsSave");
            floatingActionButton.setVisibility(loaded.getShowSave() ? 0 : 8);
            getBinding().f16779f.setOnClickListener(new ViewOnClickListenerC85743());
        }
    }

    private final WidgetGuildFolderSettingsBinding getBinding() {
        return (WidgetGuildFolderSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @ColorInt
    private final int[] getColorsToDisplay(@ColorInt int currentColor) throws Resources.NotFoundException {
        int[] intArray = getResources().getIntArray(C5419R.array.color_picker_palette);
        Intrinsics3.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…ray.color_picker_palette)");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i : intArray) {
            arrayList.add(Integer.valueOf(i));
            if (i == currentColor) {
                z2 = true;
            }
        }
        if (!z2) {
            arrayList.add(Integer.valueOf(currentColor));
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Number) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    private final WidgetGuildFolderSettingsViewModel getViewModel() {
        return (WidgetGuildFolderSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildFolderSettingsViewModel.Event event) {
        if (!(event instanceof WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsSuccess)) {
            if (event instanceof WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsFailure) {
                AppToast.m169g(getContext(), ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsFailure) event).getFailureMessageStringRes(), 0, null, 12);
            }
        } else {
            AppToast.m171i(this, ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void launchColorPicker(WidgetGuildFolderSettingsViewModel.ViewState.Loaded data) {
        Integer numRgbColorToARGB = rgbColorToARGB(data.getFormState().getColor());
        int iIntValue = numRgbColorToARGB != null ? numRgbColorToARGB.intValue() : ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand);
        ColorPickerDialog.C11163k c11163k = new ColorPickerDialog.C11163k();
        c11163k.f21754h = iIntValue;
        c11163k.f21765s = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundPrimary);
        c11163k.f21755i = false;
        c11163k.f21753g = getColorsToDisplay(iIntValue);
        c11163k.f21747a = C5419R.string.guild_folder_color;
        c11163k.f21764r = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        c11163k.f21770x = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_display_bold);
        c11163k.f21761o = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundAccent);
        c11163k.f21749c = C5419R.string.color_picker_custom;
        c11163k.f21768v = ColorCompat.getColor(getContext(), C5419R.color.white);
        c11163k.f21748b = C5419R.string.color_picker_presets;
        c11163k.f21762p = ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand);
        c11163k.f21750d = C5419R.string.select;
        c11163k.f21758l = true;
        c11163k.f21751e = C5419R.string.reset;
        c11163k.f21769w = ColorCompat.getColor(getContext(), C5419R.color.white);
        c11163k.f21771y = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_semibold);
        c11163k.f21763q = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundModifierAccent);
        c11163k.f21766t = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextMuted);
        c11163k.f21767u = C5419R.drawable.drawable_cpv_edit_text_background;
        c11163k.f21772z = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogM9275a = c11163k.m9275a();
        colorPickerDialogM9275a.f21719k = new C85751();
        AppFragment.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogM9275a.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final Integer rgbColorToARGB(Integer color) {
        if (color != null) {
            return Integer.valueOf((int) (color.intValue() + 4278190080L));
        }
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.server_folder_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableM11112r, WidgetGuildFolderSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85761(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildFolderSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85772(this), 62, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
