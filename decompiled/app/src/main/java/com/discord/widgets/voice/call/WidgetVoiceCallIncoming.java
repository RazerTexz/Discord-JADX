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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.model.CallModel;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Func0;

/* compiled from: WidgetVoiceCallIncoming.kt */
/* loaded from: classes.dex */
public class WidgetVoiceCallIncoming extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetVoiceCallIncoming.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", 0)};

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
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getCallsIncoming().observeIncoming().m11099Y(WidgetVoiceCallIncoming2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(CallModel callModel, List<StoreVoiceParticipants.VoiceUser> list, int i) {
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(list, "privateCallUserListItems");
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
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
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
            return Intrinsics3.areEqual(this.callModel, model.callModel) && Intrinsics3.areEqual(this.privateCallUserListItems, model.privateCallUserListItems) && this.numIncomingCalls == model.numIncomingCalls;
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
            StringBuilder sbM833U = outline.m833U("Model(callModel=");
            sbM833U.append(this.callModel);
            sbM833U.append(", privateCallUserListItems=");
            sbM833U.append(this.privateCallUserListItems);
            sbM833U.append(", numIncomingCalls=");
            return outline.m814B(sbM833U, this.numIncomingCalls, ")");
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
            Intrinsics3.checkNotNullParameter(model, "model");
            NotificationClient.clear$default(NotificationClient.INSTANCE, model.getChannelId(), requireContext(), false, 4, null);
            DiscordConnectService.INSTANCE.m8375b(requireContext(), model.getChannelId());
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
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            Observable<Long> observableM11068d0 = Observable.m11068d0(15L, TimeUnit.SECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(15, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), SystemCallIncoming.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetVoiceCallIncoming3(this), 62, (Object) null);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$1 */
    public static final class C104161<R> implements Func0<Boolean> {
        public final /* synthetic */ Model $model;

        public C104161(Model model) {
            this.$model = model;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetVoiceCallIncoming.this.onDecline(this.$model.getChannelId());
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$2 */
    public static final class ViewOnClickListenerC104172 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC104172(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onConnect(this.$model, true);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$3 */
    public static final class ViewOnClickListenerC104183 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC104183(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onConnect(this.$model, false);
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$configureUI$4 */
    public static final class ViewOnClickListenerC104194 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC104194(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceCallIncoming.this.onDecline(this.$model.getChannelId());
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$onViewBound$1 */
    public static final class C104201 implements OnApplyWindowInsetsListener {
        public static final C104201 INSTANCE = new C104201();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetVoiceCallIncoming.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C104211 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C104211(WidgetVoiceCallIncoming widgetVoiceCallIncoming) {
            super(1, widgetVoiceCallIncoming, WidgetVoiceCallIncoming.class, "configureUI", "configureUI(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetVoiceCallIncoming) this.receiver).configureUI(model);
        }
    }

    public WidgetVoiceCallIncoming() {
        super(C5419R.layout.widget_voice_call_incoming);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceCallIncoming4.INSTANCE, null, 2, null);
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
        AppFragment.setOnBackPressed$default(this, new C104161(model), 0, 2, null);
        AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_CALL_RINGING());
        TextView textView = getBinding().f18452g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.incomingCallStatusPrimary");
        if (ChannelUtils.m7702z(callModel.getChannel())) {
            username = ChannelUtils.m7679c(callModel.getChannel());
        } else {
            StoreVoiceParticipants.VoiceUser dmRecipient = callModel.getDmRecipient();
            if (dmRecipient != null && (user = dmRecipient.getUser()) != null) {
                username = user.getUsername();
            }
        }
        textView.setText(username);
        getBinding().f18453h.setText(callModel.getIsVideoCall() ? C5419R.string.incoming_video_call : C5419R.string.incoming_call);
        getBinding().f18454i.configure(listComponent2);
        getBinding().f18450e.configure(listComponent2);
        LinearLayout linearLayout = getBinding().f18447b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.incomingCallAcceptAltContainer");
        linearLayout.setVisibility(callModel.getIsVideoCall() ? 0 : 8);
        getBinding().f18449d.setOnClickListener(new ViewOnClickListenerC104172(model));
        getBinding().f18448c.setOnClickListener(new ViewOnClickListenerC104183(model));
        getBinding().f18451f.setOnClickListener(new ViewOnClickListenerC104194(model));
    }

    public void onConnect(Model model, boolean useVideo) {
        Intrinsics3.checkNotNullParameter(model, "model");
        long channelId = model.getChannelId();
        if (model.getNumIncomingCalls() == 1) {
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        Intrinsics3.checkNotNullExpressionValue(window, "requireActivity().window");
        Intrinsics3.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        int color = ColorCompat.getColor(this, C5419R.color.transparent);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
        ViewCompat.setOnApplyWindowInsetsListener((ViewGroup) view, C104201.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C104211(this), 62, (Object) null);
    }
}
