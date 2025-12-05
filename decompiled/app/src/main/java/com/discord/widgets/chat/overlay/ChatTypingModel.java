package com.discord.widgets.chat.overlay;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorDistinctUntilChanged2;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

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
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(resolvedChannel);
            Observable<ChatTypingModel> observableM11099Y = Observable.m11074h0(new OnSubscribeLift(scalarSynchronousObservable.f27640j, new OperatorDistinctUntilChanged2(ChatTypingModel3.INSTANCE))).m11099Y(ChatTypingModel4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "Observable.just(resolved…          }\n            }");
            return observableM11099Y;
        }

        private final Observable<ChatTypingModel> getTypingObservableForDraft(Channel parentChannel) {
            Observable observableM11099Y = StoreStream.INSTANCE.getSlowMode().observeCooldownSecs(Long.valueOf(parentChannel.getId()), StoreSlowMode.Type.ThreadCreate.INSTANCE).m11099Y(new ChatTypingModel5(parentChannel));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …ldownSecs))\n            }");
            return observableM11099Y;
        }

        private final Observable<List<CharSequence>> getTypingUsers(Channel channel) {
            Observable<List<CharSequence>> observableM11112r = StoreStream.INSTANCE.getUsersTyping().observeTypingUsers(channel.getId()).m11099Y(new ChatTypingModel6(channel)).m11083G(ChatTypingModel7.INSTANCE).m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n          .g…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public final Observable<ChatTypingModel> get() {
            Observable<ChatTypingModel> observableM11112r = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().m11099Y(ChatTypingModel2.INSTANCE).m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream.getChannelsS…  .distinctUntilChanged()");
            return observableM11112r;
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
            Intrinsics3.checkNotNullParameter(list, "typingUsers");
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
            Intrinsics3.checkNotNullParameter(typingUsers, "typingUsers");
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
            return Intrinsics3.areEqual(this.typingUsers, typing.typingUsers) && this.channelRateLimit == typing.channelRateLimit && this.cooldownSecs == typing.cooldownSecs;
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
            StringBuilder sbM833U = outline.m833U("Typing(typingUsers=");
            sbM833U.append(this.typingUsers);
            sbM833U.append(", channelRateLimit=");
            sbM833U.append(this.channelRateLimit);
            sbM833U.append(", cooldownSecs=");
            return outline.m814B(sbM833U, this.cooldownSecs, ")");
        }
    }

    private ChatTypingModel() {
    }

    public /* synthetic */ ChatTypingModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
