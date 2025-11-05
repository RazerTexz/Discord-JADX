package b.a.a.f.a;

import b.a.a.f.a.d;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AudioOutputSelectionDialogViewModel.kt */
/* loaded from: classes.dex */
public final class c extends o implements Function1<StoreAudioManagerV2.State, Unit> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(StoreAudioManagerV2.State state) {
        StoreAudioManagerV2.State state2 = state;
        m.checkNotNullParameter(state2, "storeState");
        d dVar = this.this$0;
        Objects.requireNonNull(dVar);
        List<DiscordAudioManager.AudioDevice> audioDevices = state2.getAudioDevices();
        DiscordAudioManager.DeviceTypes activeAudioDevice = state2.getActiveAudioDevice();
        DiscordAudioManager.DeviceTypes deviceTypes = DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET;
        dVar.updateViewState(new d.a.C0025a(activeAudioDevice, audioDevices.get(deviceTypes.getValue()).isAvailable, audioDevices.get(deviceTypes.getValue()).com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_NAME java.lang.String, audioDevices.get(DiscordAudioManager.DeviceTypes.SPEAKERPHONE.getValue()).isAvailable, audioDevices.get(DiscordAudioManager.DeviceTypes.WIRED_HEADSET.getValue()).isAvailable, audioDevices.get(DiscordAudioManager.DeviceTypes.EARPIECE.getValue()).isAvailable));
        return Unit.a;
    }
}
