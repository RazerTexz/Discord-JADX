package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.domain.ModelBan;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import java.util.List;
import java.util.Map;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorToObservableSortedList;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func3;

/* compiled from: WidgetServerSettingsBans.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans4<T, R> implements Func1<Map<Long, ? extends ModelBan>, Observable<? extends WidgetServerSettingsBans.Model>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;

    /* compiled from: WidgetServerSettingsBans.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$1 */
    public static final class C91901<T, R> implements Func1<Guild, WidgetServerSettingsBans.Model> {
        public static final C91901 INSTANCE = new C91901();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ WidgetServerSettingsBans.Model call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsBans.Model call2(Guild guild) {
            return WidgetServerSettingsBans.Model.Companion.access$createLoading(WidgetServerSettingsBans.Model.INSTANCE, guild);
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2 */
    public static final class C91912<T, R> implements Func1<String, Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>>> {
        public final /* synthetic */ Map $bannedUserMap;

        /* compiled from: WidgetServerSettingsBans.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<ModelBan, Boolean> {
            public final /* synthetic */ String $filter;

            public AnonymousClass1(String str) {
                this.$filter = str;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(ModelBan modelBan) {
                return call2(modelBan);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(ModelBan modelBan) {
                Intrinsics3.checkNotNullExpressionValue(modelBan, "it");
                String username = modelBan.getUser().getUsername();
                String str = this.$filter;
                Intrinsics3.checkNotNullExpressionValue(str, "filter");
                return Boolean.valueOf(Strings4.contains((CharSequence) username, (CharSequence) str, true));
            }
        }

        /* compiled from: WidgetServerSettingsBans.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<ModelBan, WidgetServerSettingsBans.Model.BanItem> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ WidgetServerSettingsBans.Model.BanItem call(ModelBan modelBan) {
                return call2(modelBan);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsBans.Model.BanItem call2(ModelBan modelBan) {
                return new WidgetServerSettingsBans.Model.BanItem(modelBan);
            }
        }

        /* compiled from: WidgetServerSettingsBans.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$3, reason: invalid class name */
        public static final class AnonymousClass3<T1, T2, R> implements Func2<WidgetServerSettingsBans.Model.BanItem, WidgetServerSettingsBans.Model.BanItem, Integer> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Integer call(WidgetServerSettingsBans.Model.BanItem banItem, WidgetServerSettingsBans.Model.BanItem banItem2) {
                return call2(banItem, banItem2);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Integer call2(WidgetServerSettingsBans.Model.BanItem banItem, WidgetServerSettingsBans.Model.BanItem banItem2) {
                User user;
                String username;
                String username2;
                User user2;
                ModelBan ban = banItem.getBan();
                if (ban == null || (user = ban.getUser()) == null || (username = user.getUsername()) == null) {
                    return null;
                }
                ModelBan ban2 = banItem2.getBan();
                if (ban2 == null || (user2 = ban2.getUser()) == null || (username2 = user2.getUsername()) == null) {
                    username2 = "";
                }
                return Integer.valueOf(StringsJVM.compareTo(username, username2, true));
            }
        }

        public C91912(Map map) {
            this.$bannedUserMap = map;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<WidgetServerSettingsBans.Model.BanItem>> call2(String str) {
            Observable<R> observableM11083G = Observable.m11058B(this.$bannedUserMap.values()).m11118y(new AnonymousClass1(str)).m11083G(AnonymousClass2.INSTANCE);
            return Observable.m11074h0(new OnSubscribeLift(observableM11083G.f27640j, new OperatorToObservableSortedList(AnonymousClass3.INSTANCE, 10)));
        }
    }

    /* compiled from: WidgetServerSettingsBans.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getBanItems$1$3 */
    public static final class C91923<T1, T2, T3, R> implements Func3<Guild, Integer, List<WidgetServerSettingsBans.Model.BanItem>, WidgetServerSettingsBans.Model> {
        public static final C91923 INSTANCE = new C91923();

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetServerSettingsBans.Model call(Guild guild, Integer num, List<WidgetServerSettingsBans.Model.BanItem> list) {
            return call2(guild, num, list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetServerSettingsBans.Model call2(Guild guild, Integer num, List<WidgetServerSettingsBans.Model.BanItem> list) {
            return WidgetServerSettingsBans.Model.INSTANCE.create(guild, num, list);
        }
    }

    public WidgetServerSettingsBans4(long j, Observable observable) {
        this.$guildId = j;
        this.$filterPublisher = observable;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsBans.Model> call(Map<Long, ? extends ModelBan> map) {
        return call2(map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsBans.Model> call2(Map<Long, ? extends ModelBan> map) {
        return map == null ? StoreStream.INSTANCE.getGuilds().observeGuild(this.$guildId).m11083G(C91901.INSTANCE) : Observable.m11075i(StoreStream.INSTANCE.getGuilds().observeGuild(this.$guildId), new ScalarSynchronousObservable(Integer.valueOf(map.size())), this.$filterPublisher.m11099Y(new C91912(map)), C91923.INSTANCE);
    }
}
