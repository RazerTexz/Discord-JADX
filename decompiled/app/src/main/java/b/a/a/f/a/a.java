package b.a.a.f.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.f.a.d;
import b.a.d.g0;
import b.a.d.i0;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: AudioOutputSelectionDialog.kt */
/* loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.f.a.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0024a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public ViewOnClickListenerC0024a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET);
                a.g((a) this.k);
                return;
            }
            if (i == 1) {
                a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                a.g((a) this.k);
            } else if (i == 2) {
                a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.WIRED_HEADSET);
                a.g((a) this.k);
            } else {
                if (i != 3) {
                    throw null;
                }
                a.h((a) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.EARPIECE);
                a.g((a) this.k);
            }
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    /* renamed from: b.a.a.f.a.a$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    public static final /* synthetic */ class c extends k implements Function1<View, b.a.i.b> {
        public static final c j = new c();

        public c() {
            super(1, b.a.i.b.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public b.a.i.b invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.audio_output_selection_bluetooth_radio;
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_bluetooth_radio);
            if (materialRadioButton != null) {
                i = R.id.audio_output_selection_dialog_header;
                TextView textView = (TextView) view2.findViewById(R.id.audio_output_selection_dialog_header);
                if (textView != null) {
                    i = R.id.audio_output_selection_dialog_radio_group;
                    RadioGroup radioGroup = (RadioGroup) view2.findViewById(R.id.audio_output_selection_dialog_radio_group);
                    if (radioGroup != null) {
                        i = R.id.audio_output_selection_earpiece_radio;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_earpiece_radio);
                        if (materialRadioButton2 != null) {
                            i = R.id.audio_output_selection_speaker_radio;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_speaker_radio);
                            if (materialRadioButton3 != null) {
                                i = R.id.audio_output_selection_wired_radio;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_wired_radio);
                                if (materialRadioButton4 != null) {
                                    return new b.a.i.b((LinearLayout) view2, materialRadioButton, textView, radioGroup, materialRadioButton2, materialRadioButton3, materialRadioButton4);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    public static final class d extends o implements Function1<d.a, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(d.a aVar) {
            int id2;
            d.a aVar2 = aVar;
            m.checkNotNullParameter(aVar2, "viewState");
            a aVar3 = a.this;
            Objects.requireNonNull(aVar3);
            m.checkNotNullParameter(aVar2, "viewState");
            if (!(aVar2 instanceof d.a.b) && (aVar2 instanceof d.a.C0025a)) {
                d.a.C0025a c0025a = (d.a.C0025a) aVar2;
                int iOrdinal = c0025a.a.ordinal();
                if (iOrdinal == 2) {
                    MaterialRadioButton materialRadioButton = aVar3.i().e;
                    m.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionSpeakerRadio");
                    id2 = materialRadioButton.getId();
                } else if (iOrdinal == 3) {
                    MaterialRadioButton materialRadioButton2 = aVar3.i().f;
                    m.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionWiredRadio");
                    id2 = materialRadioButton2.getId();
                } else if (iOrdinal == 4) {
                    MaterialRadioButton materialRadioButton3 = aVar3.i().d;
                    m.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionEarpieceRadio");
                    id2 = materialRadioButton3.getId();
                } else if (iOrdinal == 5) {
                    MaterialRadioButton materialRadioButton4 = aVar3.i().f80b;
                    m.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionBluetoothRadio");
                    id2 = materialRadioButton4.getId();
                }
                aVar3.i().c.check(id2);
                MaterialRadioButton materialRadioButton5 = aVar3.i().f80b;
                m.checkNotNullExpressionValue(materialRadioButton5, "binding.audioOutputSelectionBluetoothRadio");
                materialRadioButton5.setVisibility(c0025a.f48b ? 0 : 8);
                MaterialRadioButton materialRadioButton6 = aVar3.i().f80b;
                m.checkNotNullExpressionValue(materialRadioButton6, "binding.audioOutputSelectionBluetoothRadio");
                String string = c0025a.c;
                if (string == null) {
                    string = aVar3.getString(R.string.audio_devices_bluetooth);
                }
                materialRadioButton6.setText(string);
                MaterialRadioButton materialRadioButton7 = aVar3.i().e;
                m.checkNotNullExpressionValue(materialRadioButton7, "binding.audioOutputSelectionSpeakerRadio");
                materialRadioButton7.setVisibility(c0025a.d ? 0 : 8);
                MaterialRadioButton materialRadioButton8 = aVar3.i().f;
                m.checkNotNullExpressionValue(materialRadioButton8, "binding.audioOutputSelectionWiredRadio");
                materialRadioButton8.setVisibility(c0025a.e ? 0 : 8);
                MaterialRadioButton materialRadioButton9 = aVar3.i().d;
                m.checkNotNullExpressionValue(materialRadioButton9, "binding.audioOutputSelectionEarpieceRadio");
                materialRadioButton9.setVisibility(c0025a.f ? 0 : 8);
            }
            return Unit.a;
        }
    }

    /* compiled from: AudioOutputSelectionDialog.kt */
    public static final class e extends o implements Function0<b.a.a.f.a.d> {
        public static final e j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public b.a.a.f.a.d invoke() {
            return new b.a.a.f.a.d(null, null, 3);
        }
    }

    public a() {
        super(R.layout.audio_output_selection_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.j, null, 2, null);
        e eVar = e.j;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(b.a.a.f.a.d.class), new defpackage.k(5, g0Var), new i0(eVar));
    }

    public static final void g(a aVar) {
        Objects.requireNonNull(aVar);
        Observable<Long> observableD0 = Observable.d0(300L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, aVar, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new b(aVar), 62, (Object) null);
    }

    public static final b.a.a.f.a.d h(a aVar) {
        return (b.a.a.f.a.d) aVar.viewModel.getValue();
    }

    public final b.a.i.b i() {
        return (b.a.i.b) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int themedColor = ColorCompat.getThemedColor(view, R.attr.colorInteractiveNormal);
        MaterialRadioButton materialRadioButton = i().f80b;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionBluetoothRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton, themedColor);
        MaterialRadioButton materialRadioButton2 = i().e;
        m.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionSpeakerRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton2, themedColor);
        MaterialRadioButton materialRadioButton3 = i().f;
        m.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionWiredRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton3, themedColor);
        MaterialRadioButton materialRadioButton4 = i().d;
        m.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionEarpieceRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton4, themedColor);
        i().f80b.setOnClickListener(new ViewOnClickListenerC0024a(0, this));
        i().e.setOnClickListener(new ViewOnClickListenerC0024a(1, this));
        i().f.setOnClickListener(new ViewOnClickListenerC0024a(2, this));
        i().d.setOnClickListener(new ViewOnClickListenerC0024a(3, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(((b.a.a.f.a.d) this.viewModel.getValue()).observeViewState(), this, null, 2, null), a.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
