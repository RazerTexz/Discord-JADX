package com.discord.stores;

import android.content.Context;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreEmojiGuild.kt */
/* loaded from: classes2.dex */
public final class StoreEmojiGuild extends StoreV2 {
    private long activeGuildId;
    private final Dispatcher dispatcher;
    private final Map<Long, List<ModelEmojiGuild>> guildEmoji;
    private Map<Long, ? extends List<ModelEmojiGuild>> guildEmojiSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreEmojiGuild.kt */
    /* renamed from: com.discord.stores.StoreEmojiGuild$activate$1 */
    public static final class C58991 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58991(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.access$setActiveGuildId$p(StoreEmojiGuild.this, this.$guildId);
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    /* renamed from: com.discord.stores.StoreEmojiGuild$deactivate$1 */
    public static final class C59001 extends Lambda implements Function0<Unit> {
        public C59001() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.access$setActiveGuildId$p(StoreEmojiGuild.this, -1L);
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    /* renamed from: com.discord.stores.StoreEmojiGuild$deleteEmoji$1 */
    public static final class C59011 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $emojiId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59011(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$emojiId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map mapAccess$getGuildEmoji$p = StoreEmojiGuild.access$getGuildEmoji$p(StoreEmojiGuild.this);
            Long lValueOf = Long.valueOf(this.$guildId);
            List listEmptyList = (List) StoreEmojiGuild.access$getGuildEmoji$p(StoreEmojiGuild.this).get(Long.valueOf(this.$guildId));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : listEmptyList) {
                if (this.$emojiId != ((ModelEmojiGuild) obj).getId()) {
                    arrayList.add(obj);
                }
            }
            mapAccess$getGuildEmoji$p.put(lValueOf, arrayList);
            StoreEmojiGuild.this.markChanged();
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    /* renamed from: com.discord.stores.StoreEmojiGuild$fetchGuildEmoji$1 */
    public static final class C59021 extends Lambda implements Function1<List<? extends ModelEmojiGuild>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59021(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEmojiGuild> list) {
            invoke2((List<ModelEmojiGuild>) list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEmojiGuild> list) {
            Intrinsics3.checkNotNullParameter(list, "emojis");
            StoreEmojiGuild.access$handleGuildEmojisLoaded(StoreEmojiGuild.this, this.$guildId, list);
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    /* renamed from: com.discord.stores.StoreEmojiGuild$handleGuildEmojisLoaded$1 */
    public static final class C59031 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $emojis;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59031(List list, long j) {
            super(0);
            this.$emojis = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.access$getGuildEmoji$p(StoreEmojiGuild.this).put(Long.valueOf(this.$guildId), this.$emojis);
            StoreEmojiGuild.this.markChanged();
        }
    }

    /* compiled from: StoreEmojiGuild.kt */
    /* renamed from: com.discord.stores.StoreEmojiGuild$observeGuildEmoji$1 */
    public static final class C59041 extends Lambda implements Function0<List<? extends ModelEmojiGuild>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59041(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelEmojiGuild> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelEmojiGuild> invoke2() {
            return StoreEmojiGuild.this.getGuildEmoji(this.$guildId);
        }
    }

    public StoreEmojiGuild(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildEmoji = new LinkedHashMap();
        this.guildEmojiSnapshot = Maps6.emptyMap();
        this.activeGuildId = -1L;
    }

    public static final /* synthetic */ long access$getActiveGuildId$p(StoreEmojiGuild storeEmojiGuild) {
        return storeEmojiGuild.activeGuildId;
    }

    public static final /* synthetic */ Map access$getGuildEmoji$p(StoreEmojiGuild storeEmojiGuild) {
        return storeEmojiGuild.guildEmoji;
    }

    public static final /* synthetic */ void access$handleGuildEmojisLoaded(StoreEmojiGuild storeEmojiGuild, long j, List list) {
        storeEmojiGuild.handleGuildEmojisLoaded(j, list);
    }

    public static final /* synthetic */ void access$setActiveGuildId$p(StoreEmojiGuild storeEmojiGuild, long j) {
        storeEmojiGuild.activeGuildId = j;
    }

    @Store3
    private final void handleGuildEmojisLoaded(long guildId, List<ModelEmojiGuild> emojis) {
        this.dispatcher.schedule(new C59031(emojis, guildId));
    }

    public final void activate(long guildId) {
        this.dispatcher.schedule(new C58991(guildId));
    }

    public final void deactivate() {
        this.dispatcher.schedule(new C59001());
    }

    public final void deleteEmoji(long guildId, long emojiId) {
        this.dispatcher.schedule(new C59011(guildId, emojiId));
    }

    public final void fetchGuildEmoji(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildEmojis(guildId), false, 1, null), StoreEmojiGuild.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C59021(guildId), 62, (Object) null);
    }

    public final List<ModelEmojiGuild> getGuildEmoji(long guildId) {
        return this.guildEmojiSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        Intrinsics3.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        long j = this.activeGuildId;
        if (guildId == j) {
            fetchGuildEmoji(j);
        }
    }

    public final Observable<List<ModelEmojiGuild>> observeGuildEmoji(long guildId) {
        Observable<List<ModelEmojiGuild>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59041(guildId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildEmojiSnapshot = new HashMap(this.guildEmoji);
    }
}
