package com.discord.widgets.chat.list.sheet;

import android.content.Context;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.api.user.User;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetApplicationCommandBottomSheetBinding;
import com.discord.models.commands.Application;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetApplicationCommandBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet extends AppBottomSheet {
    public static final String ARG_MESSAGE_NONCE = "arg_message_nonce";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetApplicationCommandBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetApplicationCommandBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long interactionId, long messageId, long channelId, Long guildId, long userId, long applicationId, String messageNonce) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            boolean z2 = false;
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2021-03_android_app_slash_commands_bottom_sheet_disabled", false);
            if (userExperiment != null && userExperiment.getBucket() == 1) {
                z2 = true;
            }
            if (z2) {
                return;
            }
            WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet = new WidgetApplicationCommandBottomSheet();
            Bundle bundleM832T = outline.m832T("com.discord.intent.extra.EXTRA_INTERACTION_ID", interactionId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            if (guildId != null) {
                bundleM832T.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_USER_ID", userId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_APPLICATION_ID", applicationId);
            bundleM832T.putString(WidgetApplicationCommandBottomSheet.ARG_MESSAGE_NONCE, messageNonce);
            widgetApplicationCommandBottomSheet.setArguments(bundleM832T);
            widgetApplicationCommandBottomSheet.show(fragmentManager, WidgetApplicationCommandBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureLoaded$1 */
    public static final class ViewOnClickListenerC81651 implements View.OnClickListener {
        public final /* synthetic */ WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC81651(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = WidgetApplicationCommandBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            AppToast.m165c(contextRequireContext, WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(this.$viewState.getApplicationCommandData(), this.$viewState.getCommandValues()), 0, 4);
            WidgetApplicationCommandBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetApplicationCommandBottomSheet.kt */
    /* renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$onResume$1 */
    public static final class C81661 extends Lambda implements Function1<WidgetApplicationCommandBottomSheetViewModel.ViewState, Unit> {
        public C81661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetApplicationCommandBottomSheet.access$configureUI(WidgetApplicationCommandBottomSheet.this, viewState);
        }
    }

    public WidgetApplicationCommandBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetApplicationCommandBottomSheet2.INSTANCE, null, 2, null);
        WidgetApplicationCommandBottomSheet4 widgetApplicationCommandBottomSheet4 = new WidgetApplicationCommandBottomSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetApplicationCommandBottomSheetViewModel.class), new C8163xa0238236(appViewModelDelegates3), new AppViewModelDelegates5(widgetApplicationCommandBottomSheet4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet, WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
        widgetApplicationCommandBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet) {
        return widgetApplicationCommandBottomSheet.getArgumentsOrDefault();
    }

    private final void configureCommandTitle(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        String name;
        String nick;
        User bot;
        StringBuilder sbM829Q = outline.m829Q(MentionUtils.SLASH_CHAR);
        sbM829Q.append(viewState.getApplicationCommandData().getName());
        String string = sbM829Q.toString();
        Application application = viewState.getApplication();
        String username = null;
        if (application == null || (bot = application.getBot()) == null || (name = bot.getUsername()) == null) {
            Application application2 = viewState.getApplication();
            name = application2 != null ? application2.getName() : null;
        }
        int themedColor = ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorTextNormal);
        Application application3 = viewState.getApplication();
        if (application3 != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f15651b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.commandBottomSheetCommandAvatar");
            IconUtils.setApplicationIcon(simpleDraweeView, application3);
        }
        TextView textView = getBinding().f15655f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandTitle");
        Object[] objArr = new Object[2];
        GuildMember interactionUser = viewState.getInteractionUser();
        if (interactionUser == null || (nick = interactionUser.getNick()) == null) {
            com.discord.models.user.User user = viewState.getUser();
            if (user != null) {
                username = user.getUsername();
            }
        } else {
            username = nick;
        }
        objArr[0] = username;
        objArr[1] = string;
        CharSequence charSequenceM212d = FormatUtils.m212d(textView, C5419R.string.system_message_application_command_used_as_title, objArr, new WidgetApplicationCommandBottomSheet3(this, viewState, themedColor));
        TextView textView2 = getBinding().f15655f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.commandBottomSheetCommandTitle");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView3 = getBinding().f15655f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.commandBottomSheetCommandTitle");
        textView3.setText(charSequenceM212d);
        TextView textView4 = getBinding().f15656g;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.commandBottomShe…mmandTitleApplicationName");
        textView4.setVisibility(name != null ? 0 : 8);
        TextView textView5 = getBinding().f15656g;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.commandBottomShe…mmandTitleApplicationName");
        textView5.setText(name);
    }

    private final void configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        ApplicationCommandData applicationCommandData = viewState.getApplicationCommandData();
        List<ApplicationCommandData3> listM7725b = viewState.getApplicationCommandData().m7725b();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        StringBuilder sbM829Q = outline.m829Q(MentionUtils.SLASH_CHAR);
        sbM829Q.append(applicationCommandData.getName());
        sbM829Q.append(' ');
        spannableStringBuilder.append((CharSequence) sbM829Q.toString());
        if (listM7725b != null) {
            Iterator<T> it = listM7725b.iterator();
            while (it.hasNext()) {
                spannableStringBuilder.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandData3) it.next()));
            }
        }
        TextView textView = getBinding().f15652c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.commandBottomSheetCommandContent");
        textView.setText(spannableStringBuilder);
    }

    private final Spannable configureSlashCommandStringOptions(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandData3 option) {
        Integer valueColor;
        int themedColor = ColorCompat.getThemedColor(this, C5419R.attr.colorHeaderPrimary);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = viewState.getCommandValues().get(option.getName());
        if ((slashCommandParam != null ? slashCommandParam.getValueColor() : null) != null && ((valueColor = slashCommandParam.getValueColor()) == null || valueColor.intValue() != 0)) {
            themedColor = slashCommandParam.getValueColor().intValue();
        }
        String value = slashCommandParam != null ? slashCommandParam.getValue() : null;
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) option.getName());
        if (!(value == null || StringsJVM.isBlank(value))) {
            SpannableStringBuilder spannableStringBuilderAppend2 = spannableStringBuilderAppend.append((CharSequence) ": ");
            Intrinsics3.checkNotNullExpressionValue(spannableStringBuilderAppend2, "builder.append(\": \")");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(themedColor);
            int length = spannableStringBuilderAppend2.length();
            spannableStringBuilderAppend2.append((CharSequence) (value + ' '));
            spannableStringBuilderAppend2.setSpan(foregroundColorSpan, length, spannableStringBuilderAppend2.length(), 17);
        }
        Intrinsics3.checkNotNullExpressionValue(spannableStringBuilderAppend, "builder");
        return spannableStringBuilderAppend;
    }

    private final void configureUI(WidgetApplicationCommandBottomSheetViewModel.ViewState viewState) {
        boolean z2 = viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loading;
        ProgressBar progressBar = getBinding().f15654e;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.commandBottomSheetCommandLoader");
        progressBar.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f15653d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.commandBottomSheetCommandCopyButton");
        materialButton.setEnabled(!z2);
        if (!(viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof WidgetApplicationCommandBottomSheetViewModel.ViewState.Failed) {
                dismiss();
            }
        } else {
            MaterialButton materialButton2 = getBinding().f15653d;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.commandBottomSheetCommandCopyButton");
            materialButton2.setEnabled(true);
            configureLoaded((WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded) viewState);
        }
    }

    private final WidgetApplicationCommandBottomSheetBinding getBinding() {
        return (WidgetApplicationCommandBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetApplicationCommandBottomSheetViewModel getViewModel() {
        return (WidgetApplicationCommandBottomSheetViewModel) this.viewModel.getValue();
    }

    public final void configureLoaded(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        configureCommandTitle(viewState);
        configureSlashCommandString(viewState);
        getBinding().f15653d.setOnClickListener(new ViewOnClickListenerC81651(viewState));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_application_command_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetApplicationCommandBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C81661(), 62, (Object) null);
    }

    private final Spannable configureSlashCommandString(WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded viewState, ApplicationCommandData3 option) {
        List<ApplicationCommandData3> listM7741c = option.m7741c();
        if (listM7741c == null || listM7741c.isEmpty()) {
            return configureSlashCommandStringOptions(viewState, option);
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append((CharSequence) (option.getName() + ' '));
        List<ApplicationCommandData3> listM7741c2 = option.m7741c();
        if (listM7741c2 != null) {
            Iterator<T> it = listM7741c2.iterator();
            while (it.hasNext()) {
                spannableStringBuilderAppend.append((CharSequence) configureSlashCommandString(viewState, (ApplicationCommandData3) it.next()));
            }
        }
        return spannableStringBuilderAppend;
    }
}
