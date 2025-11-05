package com.discord.widgets.voice.call;

import android.content.Context;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.o.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetVoiceCallInline.kt */
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceCallInline.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ViewVisibilityObserver inlineVoiceVisibilityObserver;

    /* compiled from: WidgetVoiceCallInline.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final VoiceConnected voiceConnected;

        /* compiled from: WidgetVoiceCallInline.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable observableG = VoiceConnected.INSTANCE.get().G(WidgetVoiceCallInline$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "VoiceConnected\n         …eConnected)\n            }");
                return observableG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetVoiceCallInline.kt */
        public static final /* data */ class VoiceConnected {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final MediaEngineConnection.InputMode inputMode;
            private final Channel selectedVoiceChannel;
            private final StreamContext streamContext;

            /* compiled from: WidgetVoiceCallInline.kt */
            public static final class Companion {
                private Companion() {
                }

                public final Observable<VoiceConnected> get() {
                    Observable<R> observableY = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedChannel().Y(WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1.INSTANCE);
                    m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                    return ObservableExtensionsKt.computationLatest(observableY);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public VoiceConnected(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                m.checkNotNullParameter(channel, "selectedVoiceChannel");
                m.checkNotNullParameter(inputMode, "inputMode");
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

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            /* renamed from: component3, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final VoiceConnected copy(Channel selectedVoiceChannel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                m.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                m.checkNotNullParameter(inputMode, "inputMode");
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
                return m.areEqual(this.selectedVoiceChannel, voiceConnected.selectedVoiceChannel) && m.areEqual(this.inputMode, voiceConnected.inputMode) && m.areEqual(this.streamContext, voiceConnected.streamContext);
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
                StringBuilder sbU = a.U("VoiceConnected(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", inputMode=");
                sbU.append(this.inputMode);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(")");
                return sbU.toString();
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

        /* renamed from: component1, reason: from getter */
        public final VoiceConnected getVoiceConnected() {
            return this.voiceConnected;
        }

        public final Model copy(VoiceConnected voiceConnected) {
            return new Model(voiceConnected);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && m.areEqual(this.voiceConnected, ((Model) other).voiceConnected);
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
            StringBuilder sbU = a.U("Model(voiceConnected=");
            sbU.append(this.voiceConnected);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Boolean, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreStream.INSTANCE.getMediaEngine().setPttActive(z2);
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "it");
            WidgetVoiceCallInline.access$configureUI(WidgetVoiceCallInline.this, model);
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$setWindowInsetsListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            m.checkNotNullParameter(view, "v");
            m.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public WidgetVoiceCallInline() {
        super(R.layout.widget_voice_call_inline);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetVoiceCallInline$binding$2.INSTANCE, new WidgetVoiceCallInline$binding$3(this));
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
        b bVarA = b.C0039b.a();
        MaterialButton materialButton = binding.c;
        m.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        bVarA.c(materialButton);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2701b, AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().c.setOnTouchListener(new OnPressListener(AnonymousClass2.INSTANCE));
        b bVarA = b.C0039b.a();
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        bVarA.b(materialButton);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetVoiceCallInline.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
