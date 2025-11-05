package com.discord.widgets.guilds.create;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.LayoutRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ScreenTitleView;
import com.discord.widgets.guilds.create.GuildCreateCloneViews;
import com.discord.widgets.guilds.create.WidgetGuildCreateViewModel;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.discord.widgets.nux.WidgetNuxChannelPrompt;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetGuildCreate.kt */
/* loaded from: classes2.dex */
public class WidgetGuildCreate extends AppFragment {
    public static final String ANALYTICS_SOURCE = "Guild Create";
    public static final String EXTRA_OPTIONS = "com.discord.intent.extra.EXTRA_OPTIONS";
    private static final String GUIDELINES_URL = "https://discord.com/guidelines";

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String currentImageUri;
    private final LoggingConfig loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildCreate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCreateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGuildCreate.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, Options options) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(options, "options");
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildCreate.EXTRA_OPTIONS, options);
            j.d(context, WidgetGuildCreate.class, intent);
        }

        public final void showFragment(AppFragment fragment, Options options) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(options, "options");
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetGuildCreate.EXTRA_OPTIONS, options);
            j.g(j.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetGuildCreate.class, 0, true, null, bundle, 40);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    public static final /* data */ class Options implements Parcelable {
        public static final Parcelable.Creator<Options> CREATOR = new Creator();
        private final String analyticsLocation;
        private final boolean closeWithResult;
        private final String customTitle;
        private final boolean showChannelPrompt;
        private final StockGuildTemplate template;

        public static class Creator implements Parcelable.Creator<Options> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options createFromParcel(Parcel parcel) {
                m.checkNotNullParameter(parcel, "in");
                return new Options(parcel.readString(), (StockGuildTemplate) Enum.valueOf(StockGuildTemplate.class, parcel.readString()), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Options createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Options[] newArray(int i) {
                return new Options[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Options[] newArray(int i) {
                return newArray(i);
            }
        }

        public Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3) {
            m.checkNotNullParameter(str, "analyticsLocation");
            m.checkNotNullParameter(stockGuildTemplate, "template");
            this.analyticsLocation = str;
            this.template = stockGuildTemplate;
            this.showChannelPrompt = z2;
            this.customTitle = str2;
            this.closeWithResult = z3;
        }

        public static /* synthetic */ Options copy$default(Options options, String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = options.analyticsLocation;
            }
            if ((i & 2) != 0) {
                stockGuildTemplate = options.template;
            }
            StockGuildTemplate stockGuildTemplate2 = stockGuildTemplate;
            if ((i & 4) != 0) {
                z2 = options.showChannelPrompt;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                str2 = options.customTitle;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                z3 = options.closeWithResult;
            }
            return options.copy(str, stockGuildTemplate2, z4, str3, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAnalyticsLocation() {
            return this.analyticsLocation;
        }

        /* renamed from: component2, reason: from getter */
        public final StockGuildTemplate getTemplate() {
            return this.template;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowChannelPrompt() {
            return this.showChannelPrompt;
        }

        /* renamed from: component4, reason: from getter */
        public final String getCustomTitle() {
            return this.customTitle;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getCloseWithResult() {
            return this.closeWithResult;
        }

        public final Options copy(String analyticsLocation, StockGuildTemplate template, boolean showChannelPrompt, String customTitle, boolean closeWithResult) {
            m.checkNotNullParameter(analyticsLocation, "analyticsLocation");
            m.checkNotNullParameter(template, "template");
            return new Options(analyticsLocation, template, showChannelPrompt, customTitle, closeWithResult);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Options)) {
                return false;
            }
            Options options = (Options) other;
            return m.areEqual(this.analyticsLocation, options.analyticsLocation) && m.areEqual(this.template, options.template) && this.showChannelPrompt == options.showChannelPrompt && m.areEqual(this.customTitle, options.customTitle) && this.closeWithResult == options.closeWithResult;
        }

        public final String getAnalyticsLocation() {
            return this.analyticsLocation;
        }

        public final boolean getCloseWithResult() {
            return this.closeWithResult;
        }

        public final String getCustomTitle() {
            return this.customTitle;
        }

        public final boolean getShowChannelPrompt() {
            return this.showChannelPrompt;
        }

        public final StockGuildTemplate getTemplate() {
            return this.template;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.analyticsLocation;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            StockGuildTemplate stockGuildTemplate = this.template;
            int iHashCode2 = (iHashCode + (stockGuildTemplate != null ? stockGuildTemplate.hashCode() : 0)) * 31;
            boolean z2 = this.showChannelPrompt;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            String str2 = this.customTitle;
            int iHashCode3 = (i2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z3 = this.closeWithResult;
            return iHashCode3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Options(analyticsLocation=");
            sbU.append(this.analyticsLocation);
            sbU.append(", template=");
            sbU.append(this.template);
            sbU.append(", showChannelPrompt=");
            sbU.append(this.showChannelPrompt);
            sbU.append(", customTitle=");
            sbU.append(this.customTitle);
            sbU.append(", closeWithResult=");
            return a.O(sbU, this.closeWithResult, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            m.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.analyticsLocation);
            parcel.writeString(this.template.name());
            parcel.writeInt(this.showChannelPrompt ? 1 : 0);
            parcel.writeString(this.customTitle);
            parcel.writeInt(this.closeWithResult ? 1 : 0);
        }

        public /* synthetic */ Options(String str, StockGuildTemplate stockGuildTemplate, boolean z2, String str2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? StockGuildTemplate.CREATE : stockGuildTemplate, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? false : z3);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    public static final /* data */ class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        private final long guildId;

        public static class Creator implements Parcelable.Creator<Result> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Result createFromParcel(Parcel parcel) {
                m.checkNotNullParameter(parcel, "in");
                return new Result(parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Result createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Result[] newArray(int i) {
                return new Result[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Result[] newArray(int i) {
                return newArray(i);
            }
        }

        public Result(long j) {
            this.guildId = j;
        }

        public static /* synthetic */ Result copy$default(Result result, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = result.guildId;
            }
            return result.copy(j);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final Result copy(long guildId) {
            return new Result(guildId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Result) && this.guildId == ((Result) other).guildId;
            }
            return true;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return b.a(this.guildId);
        }

        public String toString() {
            return a.C(a.U("Result(guildId="), this.guildId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            m.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onImageChosen$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildIconUri(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onImageCropped$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildIconUri(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetGuildCreateViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "it");
            WidgetGuildCreate.this.configureUI(viewState);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WidgetGuildCreateViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.Event event) {
            m.checkNotNullParameter(event, "it");
            WidgetGuildCreate.access$handleEvent(WidgetGuildCreate.this, event);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildCreate widgetGuildCreate = WidgetGuildCreate.this;
            widgetGuildCreate.hideKeyboard(widgetGuildCreate.getViews().getGuildCreateName());
            WidgetGuildCreate.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<String, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "it");
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildName(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).createGuild(WidgetGuildCreate.this.requireContext());
            WidgetGuildCreate widgetGuildCreate = WidgetGuildCreate.this;
            widgetGuildCreate.hideKeyboard(widgetGuildCreate.getView());
        }
    }

    public WidgetGuildCreate() {
        this(0, 1, null);
    }

    public WidgetGuildCreate(@LayoutRes int i) {
        super(i);
        this.args = g.lazy(new WidgetGuildCreate$$special$$inlined$args$1(this, EXTRA_OPTIONS));
        WidgetGuildCreate$viewModel$2 widgetGuildCreate$viewModel$2 = new WidgetGuildCreate$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildCreateViewModel.class), new WidgetGuildCreate$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildCreate$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildCreate$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, new WidgetGuildCreate$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ WidgetGuildCreateViewModel access$getViewModel$p(WidgetGuildCreate widgetGuildCreate) {
        return widgetGuildCreate.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildCreate widgetGuildCreate, WidgetGuildCreateViewModel.Event event) {
        widgetGuildCreate.handleEvent(event);
    }

    private final WidgetGuildCreateBinding getBinding() {
        return (WidgetGuildCreateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildCreateViewModel getViewModel() {
        return (WidgetGuildCreateViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildCreateViewModel.Event event) {
        if (event instanceof WidgetGuildCreateViewModel.Event.ShowToast) {
            b.a.d.m.i(this, ((WidgetGuildCreateViewModel.Event.ShowToast) event).getStringResId(), 0, 4);
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.LaunchChannelPrompt) {
            WidgetNuxChannelPrompt.INSTANCE.launch(requireContext(), ((WidgetGuildCreateViewModel.Event.LaunchChannelPrompt) event).getGuildId());
            requireActivity().finish();
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.CloseWithResult) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, d.g2(new Result(((WidgetGuildCreateViewModel.Event.CloseWithResult) event).getGuildId())));
                activity.finish();
                return;
            }
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) {
            if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), "Guild Create", 1, null);
                j.c(requireContext(), false, null, 6);
            } else {
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context contextRequireContext = requireContext();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetGuildInviteShare.Companion.launch$default(companion, contextRequireContext, parentFragmentManager, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), null, true, null, null, "Guild Create", 96, null);
            }
            requireActivity().finish();
        }
    }

    public void configureUI(WidgetGuildCreateViewModel.ViewState viewState) {
        ScreenTitleView screenTitleView;
        m.checkNotNullParameter(viewState, "viewState");
        if (!m.areEqual(viewState, WidgetGuildCreateViewModel.ViewState.Uninitialized.INSTANCE) && (viewState instanceof WidgetGuildCreateViewModel.ViewState.Initialized)) {
            WidgetGuildCreateViewModel.ViewState.Initialized initialized = (WidgetGuildCreateViewModel.ViewState.Initialized) viewState;
            String guildName = initialized.getGuildName(requireContext());
            if (!m.areEqual(guildName, ViewExtensions.getTextOrEmpty(getViews().getGuildCreateName()))) {
                ViewExtensions.setText(getViews().getGuildCreateName(), guildName);
            }
            if (!m.areEqual(this.currentImageUri, initialized.getGuildIconUri())) {
                getViews().getIconUploaderPlaceholderGroup().setVisibility(initialized.getGuildIconUri() == null ? 0 : 8);
                IconUtils.setIcon$default(getViews().getIconUploaderImage(), initialized.getGuildIconUri(), R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                this.currentImageUri = initialized.getGuildIconUri();
            }
            if (initialized.getCustomTitle() != null && (screenTitleView = getViews().getScreenTitleView()) != null) {
                screenTitleView.setTitle(initialized.getCustomTitle());
            }
            getViews().getGuildCreateButton().setIsLoading(initialized.isBusy());
        }
    }

    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(R.string.create_server_default_server_name_format, getArgs().getTemplate(), null, getArgs().getShowChannelPrompt(), getArgs().getAnalyticsLocation(), getArgs().getCustomTitle(), getArgs().getCloseWithResult(), null, null, null, 896, null);
    }

    public final Options getArgs() {
        return (Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews.Companion companion = GuildCreateCloneViews.INSTANCE;
        WidgetGuildCreateBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        return companion.from(binding);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, new AnonymousClass1(), ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(requireContext(), uri, mimeType, new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        getViews().getGuildCreateIconUploader().setOnClickListener(new AnonymousClass3());
        b.a.k.b.n(getViews().getGuidelinesTextView(), R.string.create_server_guidelines, new Object[]{GUIDELINES_URL}, null, 4);
        EditText editText = getViews().getGuildCreateName().getEditText();
        if (editText != null) {
            TextWatcherKt.addLifecycleAwareTextWatcher(editText, this, new AnonymousClass4());
        }
        getViews().getGuildCreateButton().setOnClickListener(new AnonymousClass5());
    }

    public /* synthetic */ WidgetGuildCreate(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_guild_create : i);
    }
}
