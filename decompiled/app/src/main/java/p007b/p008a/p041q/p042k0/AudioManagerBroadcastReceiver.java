package p007b.p008a.p041q.p042k0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import androidx.annotation.MainThread;
import androidx.core.os.EnvironmentCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.enums.AudioManagerBroadcastAction;
import com.discord.rtcconnection.enums.ScoAudioState;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
import p007b.p008a.p041q.p043l0.WiredHeadsetState;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.k0.a, reason: use source file name */
/* JADX INFO: compiled from: AudioManagerBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioManagerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public static final a f1640a = new a(null);

    /* JADX INFO: renamed from: b */
    public final Context f1641b;

    /* JADX INFO: renamed from: c */
    public final OnAudioManagerBroadcastListener f1642c;

    /* JADX INFO: renamed from: b.a.q.k0.a$a */
    /* JADX INFO: compiled from: AudioManagerBroadcastReceiver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AudioManagerBroadcastReceiver(Context context, OnAudioManagerBroadcastListener onAudioManagerBroadcastListener) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onAudioManagerBroadcastListener, "listener");
        this.f1641b = context;
        this.f1642c = onAudioManagerBroadcastListener;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        WiredHeadsetState aVar;
        Intrinsics3.checkNotNullParameter(context, "context");
        ThreadUtils.checkIsOnMainThread();
        if (intent == null) {
            return;
        }
        Objects.requireNonNull(AudioManagerBroadcastAction.INSTANCE);
        Intrinsics3.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        AudioManagerBroadcastAction audioManagerBroadcastAction = null;
        if (action != null) {
            Intrinsics3.checkNotNullParameter(action, "action");
            AudioManagerBroadcastAction[] audioManagerBroadcastActionArrValues = AudioManagerBroadcastAction.values();
            int i = 0;
            while (true) {
                if (i >= 5) {
                    break;
                }
                AudioManagerBroadcastAction audioManagerBroadcastAction2 = audioManagerBroadcastActionArrValues[i];
                if (Intrinsics3.areEqual(audioManagerBroadcastAction2.getAction(), action)) {
                    audioManagerBroadcastAction = audioManagerBroadcastAction2;
                    break;
                }
                i++;
            }
        }
        if (audioManagerBroadcastAction == null) {
            StringBuilder sbM833U = outline.m833U("unable to parse AudioManagerBroadcastAction for action: ");
            sbM833U.append(intent.getAction());
            AnimatableValueParser.m517f1("AudioManagerBroadcastReceiver", sbM833U.toString());
            return;
        }
        AnimatableValueParser.m513e1("AudioManagerBroadcastReceiver", "onReceive: action = " + audioManagerBroadcastAction);
        try {
            OnAudioManagerBroadcastListener onAudioManagerBroadcastListener = this.f1642c;
            int iOrdinal = audioManagerBroadcastAction.ordinal();
            if (iOrdinal == 0) {
                onAudioManagerBroadcastListener.mo283c(context);
                return;
            }
            if (iOrdinal == 1) {
                Intrinsics3.checkNotNullParameter(intent, "intent");
                if (!Intrinsics3.areEqual(intent.getAction(), "android.intent.action.HEADSET_PLUG")) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (intent.getIntExtra("state", 0) == 1) {
                    String stringExtra = intent.getStringExtra(ModelAuditLogEntry.CHANGE_KEY_NAME);
                    if (stringExtra == null) {
                        stringExtra = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    Intrinsics3.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"name\") ?: \"unknown\"");
                    aVar = new WiredHeadsetState.a(stringExtra, intent.getIntExtra("microphone", 0) == 1);
                } else {
                    aVar = WiredHeadsetState.b.f1669a;
                }
                onAudioManagerBroadcastListener.mo285e(context, aVar);
                return;
            }
            if (iOrdinal == 2) {
                onAudioManagerBroadcastListener.mo282b(context, ScoAudioState.INSTANCE.m8499b(intent));
                return;
            }
            if (iOrdinal == 3) {
                Intrinsics3.checkNotNullParameter(context, "$this$isMicrophoneMute");
                Intrinsics3.checkNotNullParameter(context, "$this$getAudioManager");
                Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                onAudioManagerBroadcastListener.mo281a(context, ((AudioManager) systemService).isMicrophoneMute());
                return;
            }
            if (iOrdinal != 4) {
                return;
            }
            Intrinsics3.checkNotNullParameter(context, "$this$isSpeakerphoneOn");
            Intrinsics3.checkNotNullParameter(context, "$this$getAudioManager");
            Object systemService2 = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
            onAudioManagerBroadcastListener.mo284d(context, ((AudioManager) systemService2).isSpeakerphoneOn());
        } catch (Throwable th) {
            AnimatableValueParser.m505c1("AudioManagerBroadcastReceiver", "error handling " + audioManagerBroadcastAction, th);
        }
    }
}
