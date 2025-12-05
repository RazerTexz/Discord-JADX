package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.Objects;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p278y2.AsynchronousMediaCodecAdapter;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter;

/* compiled from: DefaultMediaCodecAdapterFactory.java */
/* renamed from: b.i.a.c.y2.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.b {
    @Override // p007b.p225i.p226a.p242c.p278y2.MediaCodecAdapter.b
    /* renamed from: a */
    public MediaCodecAdapter mo3845a(MediaCodecAdapter.a aVar) throws Throwable {
        MediaCodec mediaCodecCreateByCodecName;
        String string;
        if (Util2.f6708a < 31) {
            MediaCodec mediaCodec = null;
            try {
                Objects.requireNonNull(aVar.f9107a);
                String str = aVar.f9107a.f9112a;
                String strValueOf = String.valueOf(str);
                AnimatableValueParser.m515f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                AnimatableValueParser.m508d0();
            } catch (IOException e) {
                e = e;
            } catch (RuntimeException e2) {
                e = e2;
            }
            try {
                AnimatableValueParser.m515f("configureCodec");
                mediaCodecCreateByCodecName.configure(aVar.f9108b, aVar.f9110d, aVar.f9111e, 0);
                AnimatableValueParser.m508d0();
                AnimatableValueParser.m515f("startCodec");
                mediaCodecCreateByCodecName.start();
                AnimatableValueParser.m508d0();
                return new SynchronousMediaCodecAdapter(mediaCodecCreateByCodecName, null, null);
            } catch (IOException | RuntimeException e3) {
                e = e3;
                mediaCodec = mediaCodecCreateByCodecName;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        }
        int iM3049g = MimeTypes.m3049g(aVar.f9109c.f7155w);
        int i = Util2.f6708a;
        switch (iM3049g) {
            case -2:
                string = "none";
                break;
            case -1:
            default:
                if (iM3049g < 10000) {
                    string = "?";
                } else {
                    StringBuilder sb = new StringBuilder(20);
                    sb.append("custom (");
                    sb.append(iM3049g);
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
        return new AsynchronousMediaCodecAdapter.b(iM3049g, false).m3846b(aVar);
    }
}
