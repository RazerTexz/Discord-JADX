package com.discord.widgets.friends;

import androidx.fragment.app.FragmentActivity;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3301k;
import p007b.p225i.p226a.p288f.p333j.p334b.C4264a;
import p007b.p225i.p226a.p288f.p333j.p334b.C4265b;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4286i;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4296n;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4298o;
import p507d0.p579g0.Charsets2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: NearbyManager.kt */
/* loaded from: classes2.dex */
public final class NearbyManager {
    public static final int CONNECTION_ERROR = 99;
    public static final int PERMISSION_DENIED = 98;
    private Long meUserId;
    private MessageListener messageListener;
    private PublishOptions messagePublishOptions;
    private MessagesClient messagesClient;
    private Message outboundMessage;
    private SubscribeOptions subscribeOptions;
    private final HashSet<Long> nearbyUserIds = new HashSet<>();
    private final BehaviorSubject<NearbyState> nearbyStateSubject = BehaviorSubject.m11130l0(NearbyState.Uninitialized.INSTANCE);

    /* compiled from: NearbyManager.kt */
    public static abstract class NearbyState {

        /* compiled from: NearbyManager.kt */
        public static final /* data */ class Connected extends NearbyState {
            private final Set<Long> nearbyUserIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Connected(Set<Long> set) {
                super(null);
                Intrinsics3.checkNotNullParameter(set, "nearbyUserIds");
                this.nearbyUserIds = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Connected copy$default(Connected connected, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = connected.nearbyUserIds;
                }
                return connected.copy(set);
            }

            public final Set<Long> component1() {
                return this.nearbyUserIds;
            }

            public final Connected copy(Set<Long> nearbyUserIds) {
                Intrinsics3.checkNotNullParameter(nearbyUserIds, "nearbyUserIds");
                return new Connected(nearbyUserIds);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connected) && Intrinsics3.areEqual(this.nearbyUserIds, ((Connected) other).nearbyUserIds);
                }
                return true;
            }

            public final Set<Long> getNearbyUserIds() {
                return this.nearbyUserIds;
            }

            public int hashCode() {
                Set<Long> set = this.nearbyUserIds;
                if (set != null) {
                    return set.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m826N(outline.m833U("Connected(nearbyUserIds="), this.nearbyUserIds, ")");
            }
        }

        /* compiled from: NearbyManager.kt */
        public static final /* data */ class Disconnected extends NearbyState {
            private final int code;

            public Disconnected(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Disconnected copy$default(Disconnected disconnected, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = disconnected.code;
                }
                return disconnected.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Disconnected copy(int code) {
                return new Disconnected(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Disconnected) && this.code == ((Disconnected) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.m814B(outline.m833U("Disconnected(code="), this.code, ")");
            }
        }

        /* compiled from: NearbyManager.kt */
        public static final class Uninitialized extends NearbyState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private NearbyState() {
        }

        public /* synthetic */ NearbyState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: NearbyManager.kt */
    /* renamed from: com.discord.widgets.friends.NearbyManager$setupBroadcaster$1 */
    public static final class C83741 extends C4265b {
        public C83741() {
        }

        @Override // p007b.p225i.p226a.p288f.p333j.p334b.C4265b
        public void onExpired() {
            super.onExpired();
            NearbyManager.this.activateNearby();
        }
    }

    /* compiled from: NearbyManager.kt */
    /* renamed from: com.discord.widgets.friends.NearbyManager$setupListener$1 */
    public static final class C83751 extends MessageListener {
        public C83751() {
        }

        @Override // com.google.android.gms.nearby.messages.MessageListener
        public void onFound(Message message) {
            Long lAccess$parseUserId;
            super.onFound(message);
            if (message == null || (lAccess$parseUserId = NearbyManager.access$parseUserId(NearbyManager.this, message)) == null) {
                return;
            }
            NearbyManager.access$foundUserId(NearbyManager.this, lAccess$parseUserId.longValue());
        }

        @Override // com.google.android.gms.nearby.messages.MessageListener
        public void onLost(Message message) {
            Long lAccess$parseUserId;
            super.onLost(message);
            if (message == null || (lAccess$parseUserId = NearbyManager.access$parseUserId(NearbyManager.this, message)) == null) {
                return;
            }
            NearbyManager.access$lostUserId(NearbyManager.this, lAccess$parseUserId.longValue());
        }
    }

    public static final /* synthetic */ void access$foundUserId(NearbyManager nearbyManager, long j) {
        nearbyManager.foundUserId(j);
    }

    public static final /* synthetic */ BehaviorSubject access$getNearbyStateSubject$p(NearbyManager nearbyManager) {
        return nearbyManager.nearbyStateSubject;
    }

    public static final /* synthetic */ HashSet access$getNearbyUserIds$p(NearbyManager nearbyManager) {
        return nearbyManager.nearbyUserIds;
    }

    public static final /* synthetic */ void access$lostUserId(NearbyManager nearbyManager, long j) {
        nearbyManager.lostUserId(j);
    }

    public static final /* synthetic */ Long access$parseUserId(NearbyManager nearbyManager, Message message) {
        return nearbyManager.parseUserId(message);
    }

    private final void buildClient(FragmentActivity fragmentActivity) {
        C4264a c4264a = new C4264a(new C4264a.a(), null);
        AnimatableValueParser.m595z(fragmentActivity, "Activity must not be null");
        AnimatableValueParser.m595z(c4264a, "Options must not be null");
        C4286i c4286i = new C4286i(fragmentActivity, c4264a);
        C3301k c3301kM5990m = c4286i.m5990m(new NearbyManager2(this));
        c4286i.m5988k(c3301kM5990m, new C4296n(c3301kM5990m), new C4298o(c3301kM5990m));
        this.messagesClient = c4286i;
    }

    private final synchronized void foundUserId(long userId) {
        Long l = this.meUserId;
        if (l == null || userId != l.longValue()) {
            this.nearbyUserIds.add(Long.valueOf(userId));
            this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
        }
    }

    private final synchronized void lostUserId(long userId) {
        this.nearbyUserIds.remove(Long.valueOf(userId));
        this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
    }

    private final Long parseUserId(Message message) {
        byte[] bArr = message.f20713l;
        Intrinsics3.checkNotNullExpressionValue(bArr, "message.content");
        String str = new String(bArr, Charsets2.f25136a);
        if (str.charAt(0) == 'u') {
            try {
                String strSubstring = str.substring(2);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return Long.valueOf(Long.parseLong(strSubstring));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private final void setupBroadcaster(long userId) {
        this.messagePublishOptions = new PublishOptions(Strategy.f20727j, new C83741(), null);
        String strM877t = outline.m877t("u:", userId);
        Charset charset = Charsets2.f25136a;
        Objects.requireNonNull(strM877t, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strM877t.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.outboundMessage = new Message(2, bytes, "", "", Message.f20711j, 0L);
    }

    private final void setupListener() {
        this.messageListener = new C83751();
        Strategy strategy = Strategy.f20727j;
        this.subscribeOptions = new SubscribeOptions(Strategy.f20728k, MessageFilter.f20718j, null);
    }

    public final void activateNearby() {
        Message message;
        PublishOptions publishOptions;
        MessageListener messageListener;
        SubscribeOptions subscribeOptions;
        MessagesClient messagesClient = this.messagesClient;
        if (messagesClient == null || (message = this.outboundMessage) == null || (publishOptions = this.messagePublishOptions) == null || (messageListener = this.messageListener) == null || (subscribeOptions = this.subscribeOptions) == null) {
            return;
        }
        this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
        messagesClient.mo5984f(message, publishOptions);
        messagesClient.mo5985g(messageListener, subscribeOptions);
    }

    public final void buildClientAndPublish(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        if (this.messagesClient == null) {
            buildClient(fragmentActivity);
        }
        activateNearby();
    }

    public final void disableNearby() {
        Message message;
        MessageListener messageListener;
        MessagesClient messagesClient = this.messagesClient;
        if (messagesClient == null || (message = this.outboundMessage) == null || (messageListener = this.messageListener) == null) {
            return;
        }
        messagesClient.mo5986h(message);
        messagesClient.mo5987i(messageListener);
        this.nearbyUserIds.clear();
        this.nearbyStateSubject.onNext(NearbyState.Uninitialized.INSTANCE);
    }

    public final Observable<NearbyState> getState() {
        BehaviorSubject<NearbyState> behaviorSubject = this.nearbyStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "nearbyStateSubject");
        return behaviorSubject;
    }

    public final void initialize(long userId) {
        this.meUserId = Long.valueOf(userId);
        setupBroadcaster(userId);
        setupListener();
    }
}
