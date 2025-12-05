package com.discord.widgets.guilds.create;

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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildCreateBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ScreenTitleView;
import com.discord.widgets.guilds.create.GuildCreateCloneViews;
import com.discord.widgets.guilds.create.WidgetGuildCreateViewModel;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.discord.widgets.nux.WidgetNuxChannelPrompt;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.functions.Action1;

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
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildCreate.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCreateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetGuildCreate.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, Options options) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(options, "options");
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildCreate.EXTRA_OPTIONS, options);
            AppScreen2.m156d(context, WidgetGuildCreate.class, intent);
        }

        public final void showFragment(AppFragment fragment, Options options) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(options, "options");
            Bundle bundle = new Bundle();
            bundle.putParcelable(WidgetGuildCreate.EXTRA_OPTIONS, options);
            AppScreen2.m158g(AppScreen2.f524g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetGuildCreate.class, 0, true, null, bundle, 40);
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
                Intrinsics3.checkNotNullParameter(parcel, "in");
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
            Intrinsics3.checkNotNullParameter(str, "analyticsLocation");
            Intrinsics3.checkNotNullParameter(stockGuildTemplate, "template");
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
            Intrinsics3.checkNotNullParameter(analyticsLocation, "analyticsLocation");
            Intrinsics3.checkNotNullParameter(template, "template");
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
            return Intrinsics3.areEqual(this.analyticsLocation, options.analyticsLocation) && Intrinsics3.areEqual(this.template, options.template) && this.showChannelPrompt == options.showChannelPrompt && Intrinsics3.areEqual(this.customTitle, options.customTitle) && this.closeWithResult == options.closeWithResult;
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
            StringBuilder sbM833U = outline.m833U("Options(analyticsLocation=");
            sbM833U.append(this.analyticsLocation);
            sbM833U.append(", template=");
            sbM833U.append(this.template);
            sbM833U.append(", showChannelPrompt=");
            sbM833U.append(this.showChannelPrompt);
            sbM833U.append(", customTitle=");
            sbM833U.append(this.customTitle);
            sbM833U.append(", closeWithResult=");
            return outline.m827O(sbM833U, this.closeWithResult, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
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
                Intrinsics3.checkNotNullParameter(parcel, "in");
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
            return C0002b.m3a(this.guildId);
        }

        public String toString() {
            return outline.m815C(outline.m833U("Result(guildId="), this.guildId, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.guildId);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onImageChosen$1 */
    public static final class C86041<T> implements Action1<String> {
        public C86041() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildIconUri(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onImageCropped$1 */
    public static final class C86051<T> implements Action1<String> {
        public C86051() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildIconUri(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$1 */
    public static final class C86061 extends Lambda implements Function1<WidgetGuildCreateViewModel.ViewState, Unit> {
        public C86061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildCreate.this.configureUI(viewState);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$2 */
    public static final class C86072 extends Lambda implements Function1<WidgetGuildCreateViewModel.Event, Unit> {
        public C86072() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCreateViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCreateViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildCreate.access$handleEvent(WidgetGuildCreate.this, event);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$3 */
    public static final class ViewOnClickListenerC86083 implements View.OnClickListener {
        public ViewOnClickListenerC86083() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildCreate widgetGuildCreate = WidgetGuildCreate.this;
            widgetGuildCreate.hideKeyboard(widgetGuildCreate.getViews().getGuildCreateName());
            WidgetGuildCreate.this.openMediaChooser();
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$4 */
    public static final class C86094 extends Lambda implements Function1<String, Unit> {
        public C86094() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildCreate.access$getViewModel$p(WidgetGuildCreate.this).updateGuildName(str);
        }
    }

    /* compiled from: WidgetGuildCreate.kt */
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreate$onResume$5 */
    public static final class ViewOnClickListenerC86105 implements View.OnClickListener {
        public ViewOnClickListenerC86105() {
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
        this.args = LazyJVM.lazy(new WidgetGuildCreate$$special$$inlined$args$1(this, EXTRA_OPTIONS));
        WidgetGuildCreate4 widgetGuildCreate4 = new WidgetGuildCreate4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildCreateViewModel.class), new WidgetGuildCreate$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildCreate4));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildCreate2.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, new WidgetGuildCreate3(this), 3);
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
            AppToast.m171i(this, ((WidgetGuildCreateViewModel.Event.ShowToast) event).getStringResId(), 0, 4);
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
                activity.setResult(-1, AnimatableValueParser.m522g2(new Result(((WidgetGuildCreateViewModel.Event.CloseWithResult) event).getGuildId())));
                activity.finish();
                return;
            }
            return;
        }
        if (event instanceof WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) {
            if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), "Guild Create", 1, null);
                AppScreen2.m155c(requireContext(), false, null, 6);
            } else {
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context contextRequireContext = requireContext();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetGuildInviteShare.Companion.launch$default(companion, contextRequireContext, parentFragmentManager, ((WidgetGuildCreateViewModel.Event.LaunchInviteShareScreen) event).getGuildId(), null, true, null, null, "Guild Create", 96, null);
            }
            requireActivity().finish();
        }
    }

    public void configureUI(WidgetGuildCreateViewModel.ViewState viewState) {
        ScreenTitleView screenTitleView;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (!Intrinsics3.areEqual(viewState, WidgetGuildCreateViewModel.ViewState.Uninitialized.INSTANCE) && (viewState instanceof WidgetGuildCreateViewModel.ViewState.Initialized)) {
            WidgetGuildCreateViewModel.ViewState.Initialized initialized = (WidgetGuildCreateViewModel.ViewState.Initialized) viewState;
            String guildName = initialized.getGuildName(requireContext());
            if (!Intrinsics3.areEqual(guildName, ViewExtensions.getTextOrEmpty(getViews().getGuildCreateName()))) {
                ViewExtensions.setText(getViews().getGuildCreateName(), guildName);
            }
            if (!Intrinsics3.areEqual(this.currentImageUri, initialized.getGuildIconUri())) {
                getViews().getIconUploaderPlaceholderGroup().setVisibility(initialized.getGuildIconUri() == null ? 0 : 8);
                IconUtils.setIcon$default(getViews().getIconUploaderImage(), initialized.getGuildIconUri(), C5419R.dimen.avatar_size_xxlarge, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                this.currentImageUri = initialized.getGuildIconUri();
            }
            if (initialized.getCustomTitle() != null && (screenTitleView = getViews().getScreenTitleView()) != null) {
                screenTitleView.setTitle(initialized.getCustomTitle());
            }
            getViews().getGuildCreateButton().setIsLoading(initialized.isBusy());
        }
    }

    public WidgetGuildCreateViewModel createViewModelFactory() {
        return new WidgetGuildCreateViewModel(C5419R.string.create_server_default_server_name_format, getArgs().getTemplate(), null, getArgs().getShowChannelPrompt(), getArgs().getAnalyticsLocation(), getArgs().getCustomTitle(), getArgs().getCloseWithResult(), null, null, null, 896, null);
    }

    public final Options getArgs() {
        return (Options) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public GuildCreateCloneViews getViews() {
        GuildCreateCloneViews.Companion companion = GuildCreateCloneViews.INSTANCE;
        WidgetGuildCreateBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        return companion.from(binding);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, new C86041(), ImageUploadDialog.PreviewType.GUILD_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(requireContext(), uri, mimeType, new C86051());
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C86061(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C86072(), 62, (Object) null);
        getViews().getGuildCreateIconUploader().setOnClickListener(new ViewOnClickListenerC86083());
        FormatUtils.m222n(getViews().getGuidelinesTextView(), C5419R.string.create_server_guidelines, new Object[]{GUIDELINES_URL}, null, 4);
        EditText editText = getViews().getGuildCreateName().getEditText();
        if (editText != null) {
            TextWatcher4.addLifecycleAwareTextWatcher(editText, this, new C86094());
        }
        getViews().getGuildCreateButton().setOnClickListener(new ViewOnClickListenerC86105());
    }

    public /* synthetic */ WidgetGuildCreate(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C5419R.layout.widget_guild_create : i);
    }
}
