package com.discord.utilities.websocket;

import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okio.ByteString;
import p507d0.p591y.Closeable;
import p507d0.p591y.ReadWrite;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ZLibWebSocketListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ZLibWebSocketListener extends WebSocketListener {
    private final Inflater inflater;
    private final Listener listener;
    private final Inflater loggingInflater;

    /* JADX INFO: compiled from: ZLibWebSocketListener.kt */
    public static abstract class Listener extends WebSocketListener {
        private final RawMessageHandler rawMessageHandler;

        public RawMessageHandler getRawMessageHandler() {
            return this.rawMessageHandler;
        }

        public abstract void onInflateError(Exception e);

        public abstract void onInflatedMessage(okhttp3.WebSocket webSocket, InputStreamReader reader, int compressedByteLength);

        @Override // okhttp3.WebSocketListener
        public final void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(bytes, "bytes");
            throw new UnsupportedOperationException();
        }

        @Override // okhttp3.WebSocketListener
        public final void onMessage(okhttp3.WebSocket webSocket, String text) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: ZLibWebSocketListener.kt */
    public static final class ZLibByteStream extends ByteArrayOutputStream {
        private static final int INFLATE_BUFFER_SIZE = 4096;
        private static final int INITIAL_BUFFER_SIZE_MULTIPLIER = 2;
        private static final CharsetDecoder UTF8_DECODER = Charset.forName(Constants.ENCODING).newDecoder();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZLibByteStream(ByteString byteString, Inflater inflater) throws IOException {
            super(byteString.mo10502j() * 2);
            Intrinsics3.checkNotNullParameter(byteString, "bytes");
            Intrinsics3.checkNotNullParameter(inflater, "inflater");
            InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(this, inflater, 4096);
            byteString.mo10509r(inflaterOutputStream);
            inflaterOutputStream.flush();
        }

        public final InputStreamReader toReader() {
            return new InputStreamReader(new ByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count), UTF8_DECODER);
        }
    }

    public ZLibWebSocketListener(Listener listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.loggingInflater = new Inflater();
        this.inflater = new Inflater();
    }

    private final void resetInflaters() {
        this.inflater.reset();
        this.loggingInflater.reset();
    }

    public final Listener getListener() {
        return this.listener;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        resetInflaters();
        this.listener.onClosed(webSocket, code, reason);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        resetInflaters();
        this.listener.onClosing(webSocket, code, reason);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(t, "t");
        resetInflaters();
        this.listener.onFailure(webSocket, t, response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, String text) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.listener.onMessage(webSocket, text);
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(okhttp3.WebSocket webSocket, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(response, "response");
        resetInflaters();
        this.listener.onOpen(webSocket, response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) throws IOException {
        InputStreamReader reader;
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(bytes, "bytes");
        if (this.listener.getRawMessageHandler() != null) {
            try {
                reader = new ZLibByteStream(bytes, this.loggingInflater).toReader();
                try {
                    String text = ReadWrite.readText(reader);
                    RawMessageHandler rawMessageHandler = this.listener.getRawMessageHandler();
                    Intrinsics3.checkNotNull(rawMessageHandler);
                    rawMessageHandler.onRawMessage(text);
                    Closeable.closeFinally(reader, null);
                } finally {
                }
            } catch (Throwable th) {
                RawMessageHandler rawMessageHandler2 = this.listener.getRawMessageHandler();
                Intrinsics3.checkNotNull(rawMessageHandler2);
                rawMessageHandler2.onRawMessageInflateFailed(th);
            }
        }
        try {
            reader = new ZLibByteStream(bytes, this.inflater).toReader();
            try {
                this.listener.onInflatedMessage(webSocket, reader, bytes.mo10502j());
                Closeable.closeFinally(reader, null);
            } finally {
            }
        } catch (Exception e) {
            this.listener.onInflateError(e);
        }
    }
}
