package b.i.a.c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.Settings;
import b.i.a.c.t2.p;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import java.util.ArrayList;

/* compiled from: DefaultRenderersFactory.java */
/* loaded from: classes3.dex */
public class b1 implements i2 {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.a.c.y2.r f836b = new b.i.a.c.y2.r();
    public b.i.a.c.y2.v c;

    public b1(Context context) {
        this.a = context;
        int i = b.i.a.c.y2.v.a;
        this.c = b.i.a.c.y2.k.f1305b;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    @Override // b.i.a.c.i2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f2[] a(Handler handler, b.i.a.c.g3.x xVar, b.i.a.c.t2.r rVar, b.i.a.c.b3.l lVar, b.i.a.c.z2.e eVar) {
        boolean z2;
        b.i.a.c.t2.p pVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b.i.a.c.g3.r(this.a, this.f836b, this.c, 5000L, false, handler, xVar, 50));
        Context context = this.a;
        b.i.a.c.t2.p pVar2 = b.i.a.c.t2.p.a;
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        int i = b.i.a.c.f3.e0.a;
        if (i >= 17) {
            String str = b.i.a.c.f3.e0.c;
            z2 = "Amazon".equals(str) || "Xiaomi".equals(str);
        }
        if (z2 && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            pVar = b.i.a.c.t2.p.f1125b;
        } else if (i < 29) {
            pVar = (intentRegisterReceiver == null || intentRegisterReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? b.i.a.c.t2.p.a : new b.i.a.c.t2.p(intentRegisterReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), intentRegisterReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        } else {
            if (!b.i.a.c.f3.e0.A(context)) {
                if (i >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                }
            }
            pVar = new b.i.a.c.t2.p(p.a.a(), 8);
        }
        arrayList.add(new b.i.a.c.t2.z(this.a, this.f836b, this.c, false, handler, rVar, new DefaultAudioSink(pVar, new DefaultAudioSink.d(new AudioProcessor[0]), false, false, 0)));
        arrayList.add(new b.i.a.c.b3.m(lVar, handler.getLooper()));
        arrayList.add(new b.i.a.c.z2.f(eVar, handler.getLooper()));
        arrayList.add(new b.i.a.c.g3.z.e());
        return (f2[]) arrayList.toArray(new f2[0]);
    }
}
