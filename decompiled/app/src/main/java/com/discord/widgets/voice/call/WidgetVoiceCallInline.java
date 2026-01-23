package com.discord.widgets.voice.call;

import android.content.Context;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p039o.PanelsChildGestureRegionObserver;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetVoiceCallInline.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ViewVisibilityObserver inlineVoiceVisibilityObserver;

    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final VoiceConnected voiceConnected;

        /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable observableM11083G = VoiceConnected.INSTANCE.get().m11083G(WidgetVoiceCallInline2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11083G, "VoiceConnected\n         …eConnected)\n            }");
                return observableM11083G;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
        public static final /* data */ class VoiceConnected {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final MediaEngineConnection.InputMode inputMode;
            private final Channel selectedVoiceChannel;
            private final StreamContext streamContext;

            /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
            public static final class Companion {
                private Companion() {
                }

                public final Observable<VoiceConnected> get() {
                    Observable<R> observableM11099Y = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedChannel().m11099Y(WidgetVoiceCallInline3.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                    return ObservableExtensionsKt.computationLatest(observableM11099Y);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public VoiceConnected(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                this.selectedVoiceChannel = channel;
                this.inputMode = inputMode;
                this.streamContext = streamContext;
            }

            public static /* synthetic */ VoiceConnected copy$default(VoiceConnected voiceConnected, Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = voiceConnected.selectedVoiceChannel;
                }
                if ((i & 2) != 0) {
                    inputMode = voiceConnected.inputMode;
                }
                if ((i & 4) != 0) {
                    streamContext = voiceConnected.streamContext;
                }
                return voiceConnected.copy(channel, inputMode, streamContext);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final VoiceConnected copy(Channel selectedVoiceChannel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                return new VoiceConnected(selectedVoiceChannel, inputMode, streamContext);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VoiceConnected)) {
                    return false;
                }
                VoiceConnected voiceConnected = (VoiceConnected) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, voiceConnected.selectedVoiceChannel) && Intrinsics3.areEqual(this.inputMode, voiceConnected.inputMode) && Intrinsics3.areEqual(this.streamContext, voiceConnected.streamContext);
            }

            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                MediaEngineConnection.InputMode inputMode = this.inputMode;
                int iHashCode2 = (iHashCode + (inputMode != null ? inputMode.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                return iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("VoiceConnected(selectedVoiceChannel=");
                sbM833U.append(this.selectedVoiceChannel);
                sbM833U.append(", inputMode=");
                sbM833U.append(this.inputMode);
                sbM833U.append(", streamContext=");
                sbM833U.append(this.streamContext);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        public Model(VoiceConnected voiceConnected) {
            this.voiceConnected = voiceConnected;
        }

        public static /* synthetic */ Model copy$default(Model model, VoiceConnected voiceConnected, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceConnected = model.voiceConnected;
            }
            return model.copy(voiceConnected);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VoiceConnected getVoiceConnected() {
            return this.voiceConnected;
        }

        public final Model copy(VoiceConnected voiceConnected) {
            return new Model(voiceConnected);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.voiceConnected, ((Model) other).voiceConnected);
            }
            return true;
        }

        public final VoiceConnected getVoiceConnected() {
            return this.voiceConnected;
        }

        public int hashCode() {
            VoiceConnected voiceConnected = this.voiceConnected;
            if (voiceConnected != null) {
                return voiceConnected.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(voiceConnected=");
            sbM833U.append(this.voiceConnected);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class ViewOnClickListenerC104231 implements View.OnClickListener {
        public static final ViewOnClickListenerC104231 INSTANCE = new ViewOnClickListenerC104231();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class C104242 extends Lambda implements Function1<Boolean, Unit> {
        public static final C104242 INSTANCE = new C104242();

        public C104242() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            StoreStream.INSTANCE.getMediaEngine().setPttActive(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class C104251 extends Lambda implements Function1<Model, Unit> {
        public C104251() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetVoiceCallInline.access$configureUI(WidgetVoiceCallInline.this, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$setWindowInsetsListeners$1 */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class C104261 implements OnApplyWindowInsetsListener {
        public static final C104261 INSTANCE = new C104261();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public WidgetVoiceCallInline() {
        super(C5419R.layout.widget_voice_call_inline);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetVoiceCallInline4.INSTANCE, new WidgetVoiceCallInline5(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceCallInline widgetVoiceCallInline, Model model) {
        widgetVoiceCallInline.configureUI(model);
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetVoiceCallInline widgetVoiceCallInline, WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        widgetVoiceCallInline.onViewBindingDestroy(widgetVoiceCallInlineBinding);
    }

    private final void configureUI(Model data) {
        Model.VoiceConnected voiceConnected;
        boolean z2 = ((data == null || (voiceConnected = data.getVoiceConnected()) == null) ? null : voiceConnected.getInputMode()) == MediaEngineConnection.InputMode.PUSH_TO_TALK;
        View view = getView();
        if (view != null) {
            ViewKt.setVisible(view, z2);
        }
        this.inlineVoiceVisibilityObserver.updateVisibility(z2);
        if (data == null) {
        }
    }

    private final WidgetVoiceCallInlineBinding getBinding() {
        return (WidgetVoiceCallInlineBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetVoiceCallInlineBinding binding) {
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a = PanelsChildGestureRegionObserver.b.m232a();
        MaterialButton materialButton = binding.f18457c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        panelsChildGestureRegionObserverM232a.m231c(materialButton);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f18456b, C104261.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f18457c.setOnClickListener(ViewOnClickListenerC104231.INSTANCE);
        getBinding().f18457c.setOnTouchListener(new OnPressListener(C104242.INSTANCE));
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a = PanelsChildGestureRegionObserver.b.m232a();
        MaterialButton materialButton = getBinding().f18457c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        panelsChildGestureRegionObserverM232a.m230b(materialButton);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetVoiceCallInline.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C104251(), 62, (Object) null);
    }
}
