package com.discord.widgets.search;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetSearch.kt */
/* loaded from: classes2.dex */
public final class WidgetSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_EXTRA_TARGET_ID = "INTENT_EXTRA_TARGET_ID";
    public static final String INTENT_EXTRA_TARGET_TYPE = "INTENT_EXTRA_SEARCH_TYPE";
    private static final int TARGET_TYPE_CHANNEL = 1;
    private static final int TARGET_TYPE_GUILD = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long targetId;
    private int targetType;

    /* compiled from: WidgetSearch.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void launch(long targetId, int targetType, Context context) {
            Intent intentPutExtra = new Intent().putExtra(WidgetSearch.INTENT_EXTRA_TARGET_ID, targetId).putExtra(WidgetSearch.INTENT_EXTRA_TARGET_TYPE, targetType);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_TARGET_TYPE, targetType)");
            AppScreen2.m156d(context, WidgetSearch.class, intentPutExtra);
        }

        public final void launchForChannel(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            launch(channelId, 1, context);
        }

        public final void launchForGuild(long guildId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            launch(guildId, 0, context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSearch.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final StoreSearch.DisplayState displayState;
        private final Guild guild;
        private final boolean isQueryValid;

        /* compiled from: WidgetSearch.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(int targetType, long targetId) {
                Observable<Guild> observableObserveGuild = targetType == 0 ? StoreStream.INSTANCE.getGuilds().observeGuild(targetId) : new ScalarSynchronousObservable<>(null);
                Observable<Channel> observableObservePrivateChannel = targetType == 1 ? StoreStream.INSTANCE.getChannels().observePrivateChannel(targetId) : new ScalarSynchronousObservable<>(null);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11073h = Observable.m11073h(observableObserveGuild, observableObservePrivateChannel, companion.getSearch().getDisplayState(), companion.getSearch().getStoreSearchInput().isInputValid(), WidgetSearch2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11073h, "Observable\n            .…          }\n            }");
                return ObservableExtensionsKt.computationLatest(observableM11073h);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean z2) {
            this.guild = guild;
            this.channel = channel;
            this.displayState = displayState;
            this.isQueryValid = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                channel = model.channel;
            }
            if ((i & 4) != 0) {
                displayState = model.displayState;
            }
            if ((i & 8) != 0) {
                z2 = model.isQueryValid;
            }
            return model.copy(guild, channel, displayState, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreSearch.DisplayState getDisplayState() {
            return this.displayState;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsQueryValid() {
            return this.isQueryValid;
        }

        public final Model copy(Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean isQueryValid) {
            return new Model(guild, channel, displayState, isQueryValid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.displayState, model.displayState) && this.isQueryValid == model.isQueryValid;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreSearch.DisplayState getDisplayState() {
            return this.displayState;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            StoreSearch.DisplayState displayState = this.displayState;
            int iHashCode3 = (iHashCode2 + (displayState != null ? displayState.hashCode() : 0)) * 31;
            boolean z2 = this.isQueryValid;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isQueryValid() {
            return this.isQueryValid;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", displayState=");
            sbM833U.append(this.displayState);
            sbM833U.append(", isQueryValid=");
            return outline.m827O(sbM833U, this.isQueryValid, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.DisplayState.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.DisplayState.SUGGESTIONS.ordinal()] = 1;
            iArr[StoreSearch.DisplayState.RESULTS.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$1 */
    public static final class C91261 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public C91261() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (i != 2 && i != 3 && i != 6) {
                return false;
            }
            AppFragment.hideKeyboard$default(WidgetSearch.this, null, 1, null);
            StoreSearch search = StoreStream.INSTANCE.getSearch();
            TextInputLayout textInputLayout = WidgetSearch.access$getBinding$p(WidgetSearch.this).f17421c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "textView.context");
            search.loadInitial(textOrEmpty, new ContextSearchStringProvider(context));
            return true;
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$2 */
    public static final class C91272 extends Lambda implements Function1<Editable, Unit> {
        public static final C91272 INSTANCE = new C91272();

        public C91272() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().updateInput(editable.toString());
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$3 */
    public static final class C91283<T, R> implements Func1<List<? extends QueryNode>, DraweeSpanStringBuilder> {
        public C91283() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ DraweeSpanStringBuilder call(List<? extends QueryNode> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final DraweeSpanStringBuilder call2(List<? extends QueryNode> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "queryNodes");
            return AstRenderer.render(list, WidgetSearch.this.requireContext());
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$4 */
    public static final class C91294<T, R> implements Func1<DraweeSpanStringBuilder, String> {
        public static final C91294 INSTANCE = new C91294();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ String call(DraweeSpanStringBuilder draweeSpanStringBuilder) {
            return call2(draweeSpanStringBuilder);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(DraweeSpanStringBuilder draweeSpanStringBuilder) {
            Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, IconCompat.EXTRA_OBJ);
            return draweeSpanStringBuilder.toString();
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$5 */
    public static final class C91305 extends Lambda implements Function1<String, Unit> {
        public C91305() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            TextInputLayout textInputLayout = WidgetSearch.access$getBinding$p(WidgetSearch.this).f17421c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            ViewExtensions.setText(textInputLayout, str);
            TextInputLayout textInputLayout2 = WidgetSearch.access$getBinding$p(WidgetSearch.this).f17421c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            ViewExtensions.setSelectionEnd(textInputLayout2);
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$1 */
    public static final class C91311 extends Lambda implements Function1<Model, Unit> {
        public C91311() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetSearch.access$configureUI(WidgetSearch.this, model);
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$2 */
    public static final class ViewOnClickListenerC91322 implements View.OnClickListener {
        public ViewOnClickListenerC91322() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSearch widgetSearch = WidgetSearch.this;
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            WidgetSearch.access$sendQuery(widgetSearch, context);
        }
    }

    /* compiled from: WidgetSearch.kt */
    /* renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$3 */
    public static final class ViewOnClickListenerC91333 implements View.OnClickListener {
        public ViewOnClickListenerC91333() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSearch.this.hideKeyboard(view);
            WidgetSearch.this.requireActivity().onBackPressed();
        }
    }

    public WidgetSearch() {
        super(C5419R.layout.widget_search);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearch3.INSTANCE, null, 2, null);
        this.targetType = -1;
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearch widgetSearch, Model model) {
        widgetSearch.configureUI(model);
    }

    public static final /* synthetic */ WidgetSearchBinding access$getBinding$p(WidgetSearch widgetSearch) {
        return widgetSearch.getBinding();
    }

    public static final /* synthetic */ void access$sendQuery(WidgetSearch widgetSearch, Context context) {
        widgetSearch.sendQuery(context);
    }

    private final void configureSearchInput() {
        TextInputLayout textInputLayout = getBinding().f17421c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        ViewExtensions.setOnEditorActionListener(textInputLayout, new C91261());
        TextInputLayout textInputLayout2 = getBinding().f17421c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, C91272.INSTANCE);
        Observable observableM11083G = ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getSearch().getStoreSearchInput().getForcedInput(), this, null, 2, null).m11083G(new C91283()).m11083G(C91294.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "StoreStream\n        .get… obj.toString()\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableM11083G, WidgetSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91305(), 62, (Object) null);
    }

    private final void configureUI(Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        int i = this.targetType;
        if (i == 0) {
            TextInputLayout textInputLayout = getBinding().f17421c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            Object[] objArr = new Object[1];
            Guild guild = model.getGuild();
            objArr[0] = guild != null ? guild.getName() : null;
            ViewExtensions.setSingleLineHint(textInputLayout, FormatUtils.m219k(this, C5419R.string.search_in, objArr, null, 4));
        } else if (i == 1) {
            Channel channel = model.getChannel();
            String strM7680d = channel != null ? ChannelUtils.m7680d(channel, requireContext(), false) : null;
            TextInputLayout textInputLayout2 = getBinding().f17421c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            Channel channel2 = model.getChannel();
            Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
            ViewExtensions.setSingleLineHint(textInputLayout2, (numValueOf != null && numValueOf.intValue() == 1) ? FormatUtils.m219k(this, C5419R.string.search_dm_with, new Object[]{strM7680d}, null, 4) : (numValueOf != null && numValueOf.intValue() == 3) ? FormatUtils.m219k(this, C5419R.string.search_in, new Object[]{strM7680d}, null, 4) : FormatUtils.m219k(this, C5419R.string.search, new Object[0], null, 4));
        }
        StoreSearch.DisplayState displayState = model.getDisplayState();
        if (displayState == null) {
            return;
        }
        int iOrdinal = displayState.ordinal();
        if (iOrdinal == 0) {
            FragmentContainerView fragmentContainerView = getBinding().f17423e;
            Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetSearchSuggestions");
            fragmentContainerView.setVisibility(0);
            FragmentContainerView fragmentContainerView2 = getBinding().f17422d;
            Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetSearchResults");
            fragmentContainerView2.setVisibility(4);
            FloatingActionButton floatingActionButton = getBinding().f17420b;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.searchSendQueryFab");
            floatingActionButton.setVisibility(model.isQueryValid() ? 0 : 8);
            return;
        }
        if (iOrdinal != 1) {
            return;
        }
        FragmentContainerView fragmentContainerView3 = getBinding().f17423e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetSearchSuggestions");
        fragmentContainerView3.setVisibility(4);
        FragmentContainerView fragmentContainerView4 = getBinding().f17422d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetSearchResults");
        fragmentContainerView4.setVisibility(0);
        FloatingActionButton floatingActionButton2 = getBinding().f17420b;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton2, "binding.searchSendQueryFab");
        floatingActionButton2.setVisibility(8);
    }

    private final WidgetSearchBinding getBinding() {
        return (WidgetSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendQuery(Context context) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StoreSearch search = StoreStream.INSTANCE.getSearch();
        TextInputLayout textInputLayout = getBinding().f17421c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        search.loadInitial(ViewExtensions.getTextOrEmpty(textInputLayout), new ContextSearchStringProvider(context));
    }

    public final long getTargetId() {
        return this.targetId;
    }

    public final int getTargetType() {
        return this.targetType;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StoreStream.INSTANCE.getSearch().clear();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.targetId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_TARGET_ID, 0L);
        this.targetType = getMostRecentIntent().getIntExtra(INTENT_EXTRA_TARGET_TYPE, -1);
        if (!getIsRecreated()) {
            TextInputLayout textInputLayout = getBinding().f17421c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            showKeyboard(textInputLayout);
        }
        int i = this.targetType;
        if (i == 0) {
            StoreStream.INSTANCE.getSearch().initForGuild(this.targetId, new ContextSearchStringProvider(requireContext()));
        } else {
            if (i != 1) {
                return;
            }
            StoreStream.INSTANCE.getSearch().initForChannel(this.targetId, new ContextSearchStringProvider(requireContext()));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(this.targetType, this.targetId), this, null, 2, null), WidgetSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91311(), 62, (Object) null);
        configureSearchInput();
        getBinding().f17420b.setOnClickListener(new ViewOnClickListenerC91322());
        getBinding().f17421c.setStartIconOnClickListener(new ViewOnClickListenerC91333());
    }

    public final void setTargetId(long j) {
        this.targetId = j;
    }

    public final void setTargetType(int i) {
        this.targetType = i;
    }
}
