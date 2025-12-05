package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import java.util.ArrayList;
import p007b.p225i.p226a.p242c.p245b3.TextOutput;
import p007b.p225i.p226a.p242c.p245b3.TextRenderer;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.MediaCodecVideoRenderer;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;
import p007b.p225i.p226a.p242c.p260g3.p261z.CameraMotionRenderer;
import p007b.p225i.p226a.p242c.p263t2.AudioCapabilities;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p263t2.MediaCodecAudioRenderer;
import p007b.p225i.p226a.p242c.p278y2.C3139k;
import p007b.p225i.p226a.p242c.p278y2.DefaultMediaCodecAdapterFactory;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecSelector;
import p007b.p225i.p226a.p242c.p279z2.MetadataOutput;
import p007b.p225i.p226a.p242c.p279z2.MetadataRenderer;

/* compiled from: DefaultRenderersFactory.java */
/* renamed from: b.i.a.c.b1, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultRenderersFactory implements RenderersFactory {

    /* renamed from: a */
    public final Context f5739a;

    /* renamed from: b */
    public final DefaultMediaCodecAdapterFactory f5740b = new DefaultMediaCodecAdapterFactory();

    /* renamed from: c */
    public MediaCodecSelector f5741c;

    public DefaultRenderersFactory(Context context) {
        this.f5739a = context;
        int i = MediaCodecSelector.f9119a;
        this.f5741c = C3139k.f9058b;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    @Override // p007b.p225i.p226a.p242c.RenderersFactory
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Renderer2[] mo2596a(Handler handler, VideoRendererEventListener2 videoRendererEventListener2, AudioRendererEventListener2 audioRendererEventListener2, TextOutput textOutput, MetadataOutput metadataOutput) {
        boolean z2;
        AudioCapabilities audioCapabilities;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MediaCodecVideoRenderer(this.f5739a, this.f5740b, this.f5741c, 5000L, false, handler, videoRendererEventListener2, 50));
        Context context = this.f5739a;
        AudioCapabilities audioCapabilities2 = AudioCapabilities.f7785a;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        int i = Util2.f6708a;
        if (i >= 17) {
            String str = Util2.f6710c;
            z2 = "Amazon".equals(str) || "Xiaomi".equals(str);
        }
        if (z2 && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            audioCapabilities = AudioCapabilities.f7786b;
        } else if (i < 29) {
            audioCapabilities = (intentRegisterReceiver == null || intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? AudioCapabilities.f7785a : new AudioCapabilities(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        } else {
            if (!Util2.m2980A(context)) {
                if (i >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                }
            }
            audioCapabilities = new AudioCapabilities(AudioCapabilities.a.m3496a(), 8);
        }
        arrayList.add(new MediaCodecAudioRenderer(this.f5739a, this.f5740b, this.f5741c, false, handler, audioRendererEventListener2, new DefaultAudioSink(audioCapabilities, new DefaultAudioSink.C10690d(new AudioProcessor[0]), false, false, 0)));
        arrayList.add(new TextRenderer(textOutput, handler.getLooper()));
        arrayList.add(new MetadataRenderer(metadataOutput, handler.getLooper()));
        arrayList.add(new CameraMotionRenderer());
        return (Renderer2[]) arrayList.toArray(new Renderer2[0]);
    }
}
