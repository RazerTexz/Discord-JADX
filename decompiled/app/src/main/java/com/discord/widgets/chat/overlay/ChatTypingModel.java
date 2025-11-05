package com.discord.widgets.chat.overlay;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import j0.l.a.r;
import j0.l.a.u0;
import j0.l.e.k;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: ChatTypingModel.kt */
/* loaded from: classes2.dex */
public abstract class ChatTypingModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ChatTypingModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getTypingObservableForChannel(Companion companion, Channel channel) {
            return companion.getTypingObservableForChannel(channel);
        }

        public static final /* synthetic */ Observable access$getTypingObservableForDraft(Companion companion, Channel channel) {
            return companion.getTypingObservableForDraft(channel);
        }

        public static final /* synthetic */ Observable access$getTypingUsers(Companion companion, Channel channel) {
            return companion.getTypingUsers(channel);
        }

        private final Observable<ChatTypingModel> getTypingObservableForChannel(Channel resolvedChannel) {
            k kVar = new k(resolvedChannel);
            Observable<ChatTypingModel> observableY = Observable.h0(new r(kVar.j, new u0(ChatTypingModel$Companion$getTypingObservableForChannel$1.INSTANCE))).Y(ChatTypingModel$Companion$getTypingObservableForChannel$2.INSTANCE);
            m.checkNotNullExpressionValue(observableY, "Observable.just(resolved…          }\n            }");
            return observableY;
        }

        private final Observable<ChatTypingModel> getTypingObservableForDraft(Channel parentChannel) {
            Observable observableY = StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(parentChannel.getId()), StoreSlowMode.Type.ThreadCreate.INSTANCE).Y(new ChatTypingModel$Companion$getTypingObservableForDraft$1(parentChannel));
            m.checkNotNullExpressionValue(observableY, "StoreStream\n            …ldownSecs))\n            }");
            return observableY;
        }

        private final Observable<List<CharSequence>> getTypingUsers(Channel channel) {
            Observable<List<CharSequence>> observableR = StoreStream.INSTANCE.getUsersTyping().observeTypingUsers(channel.getId()).Y(new ChatTypingModel$Companion$getTypingUsers$1(channel)).G(ChatTypingModel$Companion$getTypingUsers$2.INSTANCE).r();
            m.checkNotNullExpressionValue(observableR, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableR;
        }

        public final Observable<ChatTypingModel> get() {
            Observable<ChatTypingModel> observableR = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().Y(ChatTypingModel$Companion$get$1.INSTANCE).r();
            m.checkNotNullExpressionValue(observableR, "StoreStream.getChannelsS…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ChatTypingModel.kt */
    public static final class Hide extends ChatTypingModel {
        public static final Hide INSTANCE = new Hide();

        private Hide() {
            super(null);
        }
    }

    /* compiled from: ChatTypingModel.kt */
    public static final /* data */ class Typing extends ChatTypingModel {
        private final int channelRateLimit;
        private final int cooldownSecs;
        private final List<CharSequence> typingUsers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Typing(List<? extends CharSequence> list, int i, int i2) {
            super(null);
            m.checkNotNullParameter(list, "typingUsers");
            this.typingUsers = list;
            this.channelRateLimit = i;
            this.cooldownSecs = i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Typing copy$default(Typing typing, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = typing.typingUsers;
            }
            if ((i3 & 2) != 0) {
                i = typing.channelRateLimit;
            }
            if ((i3 & 4) != 0) {
                i2 = typing.cooldownSecs;
            }
            return typing.copy(list, i, i2);
        }

        public final List<CharSequence> component1() {
            return this.typingUsers;
        }

        /* renamed from: component2, reason: from getter */
        public final int getChannelRateLimit() {
            return this.channelRateLimit;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCooldownSecs() {
            return this.cooldownSecs;
        }

        public final Typing copy(List<? extends CharSequence> typingUsers, int channelRateLimit, int cooldownSecs) {
            m.checkNotNullParameter(typingUsers, "typingUsers");
            return new Typing(typingUsers, channelRateLimit, cooldownSecs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Typing)) {
                return false;
            }
            Typing typing = (Typing) other;
            return m.areEqual(this.typingUsers, typing.typingUsers) && this.channelRateLimit == typing.channelRateLimit && this.cooldownSecs == typing.cooldownSecs;
        }

        public final int getChannelRateLimit() {
            return this.channelRateLimit;
        }

        public final int getCooldownSecs() {
            return this.cooldownSecs;
        }

        public final List<CharSequence> getTypingUsers() {
            return this.typingUsers;
        }

        public int hashCode() {
            List<CharSequence> list = this.typingUsers;
            return ((((list != null ? list.hashCode() : 0) * 31) + this.channelRateLimit) * 31) + this.cooldownSecs;
        }

        public String toString() {
            StringBuilder sbU = a.U("Typing(typingUsers=");
            sbU.append(this.typingUsers);
            sbU.append(", channelRateLimit=");
            sbU.append(this.channelRateLimit);
            sbU.append(", cooldownSecs=");
            return a.B(sbU, this.cooldownSecs, ")");
        }
    }

    private ChatTypingModel() {
    }

    public /* synthetic */ ChatTypingModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
