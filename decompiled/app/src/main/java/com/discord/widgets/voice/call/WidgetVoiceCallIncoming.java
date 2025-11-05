package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.DiscordConnectService;
import com.discord.databinding.WidgetVoiceCallIncomingBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetVoiceCallIncoming.kt */
/* loaded from: classes.dex */
public class WidgetVoiceCallIncoming extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceCallIncoming.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetVoiceCallIncoming.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CallModel callModel;
        private final int numIncomingCalls;
        private final List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems;

        /* compiled from: WidgetVoiceCallIncoming.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable<R> observableY = StoreStream.INSTANCE.getCallsIncoming().observeIncoming().Y(WidgetVoiceCallIncoming$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(CallModel callModel, List<StoreVoiceParticipants.VoiceUser> list, int i) {
            m.checkNotNullParameter(callModel, "callModel");
            m.checkNotNullParameter(list, "privateCallUserListItems");
            this.callModel = callModel;
            this.privateCallUserListItems = list;
            this.numIncomingCalls = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, CallModel callModel, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                callModel = model.callModel;
            }
            if ((i2 & 2) != 0) {
                list = model.privateCallUserListItems;
            }
            if ((i2 & 4) != 0) {
                i = model.numIncomingCalls;
            }
            return model.copy(callModel, list, i);
        }

        /* renamed from: component1, reason: from getter */
        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final List<StoreVoiceParticipants.VoiceUser> component2() {
            return this.privateCallUserListItems;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNumIncomingCalls() {
            return this.numIncomingCalls;
        }

        public final Model copy(CallModel callModel, List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems, int numIncomingCalls) {
            m.checkNotNullParameter(callModel, "callModel");
            m.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
            return new Model(callModel, privateCallUserListItems, numIncomingCalls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.callModel, model.callModel) && m.areEqual(this.privateCallUserListItems, model.privateCallUserListItems) && this.numIncomingCalls == model.numIncomingCalls;
        }

        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final long getChannelId() {
            return this.callModel.getChannel().getId();
        }

        public final int getNumIncomingCalls() {
            return this.numIncomingCalls;
        }

        public final List<StoreVoiceParticipants.VoiceUser> getPrivateCallUserListItems() {
            return this.privateCallUserListItems;
        }

        public int hashCode() {
            CallModel callModel = this.callModel;
            int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
            List<StoreVoiceParticipants.VoiceUser> list = this.privateCallUserListItems;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.numIncomingCalls;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(callModel=");
            sbU.append(this.callModel);
            sbU.append(", privateCallUserListItems=");
            sbU.append(this.privateCallUserListItems);
            sbU.append(", numIncomingCalls=");
            return a.B(sbU, this.numIncomingCalls, ")");
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    public static final class SystemCallIncoming extends WidgetVoiceCallIncoming {
        private AtomicLong cachedChannelId = new AtomicLong(0);

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void configureUI(Model model) {
            if ((model != null ? Long.valueOf(model.getChannelId()) : null) != null) {
                this.cachedChannelId.set(model.getChannelId());
            }
            super.configureUI(model);
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onConnect(Model model, boolean useVideo) {
            m.checkNotNullParameter(model, "model");
            NotificationClient.clear$default(NotificationClient.INSTANCE, model.getChannelId(), requireContext(), false, 4, null);
            DiscordConnectService.INSTANCE.b(requireContext(), model.getChannelId());
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), model.getChannelId(), false, null, null, 28, null);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onDecline(long channelId) {
            super.onDecline(channelId);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onEmptyCallModel() {
            long j = this.cachedChannelId.get();
            if (j == 0) {
                return;
            }
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
            NotificationClient.clear$default(NotificationClient.INSTANCE, j, requireContext(), false, 4, null);
        }

        @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            m.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            Observable<Long> observableD0 = Observable.d0(15L, TimeUnit.SECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable.timer(15, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), SystemCallIncoming.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceCallIncoming$SystemCallIncoming$onViewCreated$1(this), 62, (Object) null);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetVoiceCallIncoming.this.onDecline(this.$model.getChannelId());
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onConnect(this.$model, true);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onConnect(this.$model, false);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass4(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onDecline(this.$model.getChannelId());
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetVoiceCallIncoming widgetVoiceCallIncoming) {
            super(1, widgetVoiceCallIncoming, WidgetVoiceCallIncoming.class, "configureUI", "configureUI(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetVoiceCallIncoming) this.receiver).configureUI(model);
        }
    }

    public WidgetVoiceCallIncoming() {
        super(R.layout.widget_voice_call_incoming);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceCallIncoming$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetVoiceCallIncomingBinding getBinding() {
        return (WidgetVoiceCallIncomingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void configureUI(Model model) {
        User user;
        String username = null;
        if ((model != null ? model.getCallModel() : null) == null) {
            onEmptyCallModel();
            return;
        }
        CallModel callModel = model.getCallModel();
        List<StoreVoiceParticipants.VoiceUser> listComponent2 = model.component2();
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(model), 0, 2, null);
        AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_CALL_RINGING());
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.incomingCallStatusPrimary");
        if (ChannelUtils.z(callModel.getChannel())) {
            username = ChannelUtils.c(callModel.getChannel());
        } else {
            StoreVoiceParticipants.VoiceUser dmRecipient = callModel.getDmRecipient();
            if (dmRecipient != null && (user = dmRecipient.getUser()) != null) {
                username = user.getUsername();
            }
        }
        textView.setText(username);
        getBinding().h.setText(callModel.getIsVideoCall() ? R.string.incoming_video_call : R.string.incoming_call);
        getBinding().i.configure(listComponent2);
        getBinding().e.configure(listComponent2);
        LinearLayout linearLayout = getBinding().f2700b;
        m.checkNotNullExpressionValue(linearLayout, "binding.incomingCallAcceptAltContainer");
        linearLayout.setVisibility(callModel.getIsVideoCall() ? 0 : 8);
        getBinding().d.setOnClickListener(new AnonymousClass2(model));
        getBinding().c.setOnClickListener(new AnonymousClass3(model));
        getBinding().f.setOnClickListener(new AnonymousClass4(model));
    }

    public void onConnect(Model model, boolean useVideo) {
        m.checkNotNullParameter(model, "model");
        long channelId = model.getChannelId();
        if (model.getNumIncomingCalls() == 1) {
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
            if (useVideo) {
                privateCallLauncher.launchVideoCall(channelId);
            } else {
                privateCallLauncher.launchVoiceCall(channelId);
            }
        } else {
            if (useVideo) {
                StoreMediaEngine.selectDefaultVideoDevice$default(StoreStream.INSTANCE.getMediaEngine(), null, 1, null);
            }
            StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(channelId);
        }
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    @MainThread
    public void onDecline(long channelId) {
        StoreCalls.stopRinging$default(StoreStream.INSTANCE.getCalls(), channelId, null, 2, null);
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    public void onEmptyCallModel() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AppSoundManager.Provider.INSTANCE.get().stop(AppSound.INSTANCE.getSOUND_CALL_RINGING());
        super.onStop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        m.checkNotNullExpressionValue(window, "requireActivity().window");
        m.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        int color = ColorCompat.getColor(this, R.color.transparent);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
        ViewCompat.setOnApplyWindowInsetsListener((ViewGroup) view, AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
