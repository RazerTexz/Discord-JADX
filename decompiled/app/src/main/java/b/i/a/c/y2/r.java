package b.i.a.c.y2;

import android.media.MediaCodec;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.i.a.c.f3.e0;
import b.i.a.c.y2.l;
import b.i.a.c.y2.t;
import java.io.IOException;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;

/* compiled from: DefaultMediaCodecAdapterFactory.java */
/* loaded from: classes3.dex */
public final class r implements t.b {
    @Override // b.i.a.c.y2.t.b
    public t a(t.a aVar) throws Throwable {
        MediaCodec mediaCodecCreateByCodecName;
        String string;
        if (e0.a < 31) {
            MediaCodec mediaCodec = null;
            try {
                Objects.requireNonNull(aVar.a);
                String str = aVar.a.a;
                String strValueOf = String.valueOf(str);
                b.c.a.a0.d.f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                b.c.a.a0.d.d0();
            } catch (IOException e) {
                e = e;
            } catch (RuntimeException e2) {
                e = e2;
            }
            try {
                b.c.a.a0.d.f("configureCodec");
                mediaCodecCreateByCodecName.configure(aVar.f1314b, aVar.d, aVar.e, 0);
                b.c.a.a0.d.d0();
                b.c.a.a0.d.f("startCodec");
                mediaCodecCreateByCodecName.start();
                b.c.a.a0.d.d0();
                return new w(mediaCodecCreateByCodecName, null, null);
            } catch (IOException | RuntimeException e3) {
                e = e3;
                mediaCodec = mediaCodecCreateByCodecName;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        }
        int iG = b.i.a.c.f3.t.g(aVar.c.w);
        int i = e0.a;
        switch (iG) {
            case -2:
                string = "none";
                break;
            case -1:
            default:
                if (iG < 10000) {
                    string = "?";
                } else {
                    StringBuilder sb = new StringBuilder(20);
                    sb.append("custom (");
                    sb.append(iG);
                    sb.append(")");
                    string = sb.toString();
                }
                break;
            case 0:
                string = "default";
                break;
            case 1:
                string = MediaStreamTrack.AUDIO_TRACK_KIND;
                break;
            case 2:
                string = MediaStreamTrack.VIDEO_TRACK_KIND;
                break;
            case 3:
                string = NotificationCompat.MessagingStyle.Message.KEY_TEXT;
                break;
            case 4:
                string = "image";
                break;
            case 5:
                string = "metadata";
                break;
            case 6:
                string = "camera motion";
                break;
        }
        String strValueOf2 = String.valueOf(string);
        Log.i("DefaultMediaCodecAdapterFactory", strValueOf2.length() != 0 ? "Creating an asynchronous MediaCodec adapter for track type ".concat(strValueOf2) : new String("Creating an asynchronous MediaCodec adapter for track type "));
        return new l.b(iG, false).b(aVar);
    }
}
