package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* compiled from: WidgetGroupInviteFriends.kt */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2<T, R> implements Func1<List<Long>, Observable<? extends Map<Long, Integer>>> {
    public final /* synthetic */ String $nameFilter;

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends Map<Long, Integer>>> {
        public final /* synthetic */ List $excludeUserIds;

        /* compiled from: WidgetGroupInviteFriends.kt */
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02411<T, R> implements Func1<Map<Long, ? extends User>, Observable<? extends Map<Long, Integer>>> {
            public final /* synthetic */ Map $relationships;

            /* compiled from: WidgetGroupInviteFriends.kt */
            /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02421<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Boolean> {
                public final /* synthetic */ Map $users;

                public C02421(Map map) {
                    this.$users = map;
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Boolean call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
                /* renamed from: call, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean call2(Map.Entry<Long, Integer> entry) {
                    boolean zContains;
                    User user;
                    String username;
                    boolean z2 = true;
                    if (AnonymousClass1.this.$excludeUserIds.contains(entry.getKey()) || !this.$users.containsKey(entry.getKey())) {
                        z2 = false;
                    } else {
                        Map map = this.$users;
                        if (map == null || (user = (User) map.get(entry.getKey())) == null || (username = user.getUsername()) == null) {
                            zContains = false;
                        } else {
                            String str = WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2.this.$nameFilter;
                            if (str != null) {
                                String lowerCase = str.toLowerCase();
                                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                                if (lowerCase == null) {
                                    lowerCase = "";
                                }
                                zContains = Strings4.contains((CharSequence) username, (CharSequence) lowerCase, true);
                            }
                        }
                        if (!zContains) {
                        }
                    }
                    return Boolean.valueOf(z2);
                }
            }

            /* compiled from: WidgetGroupInviteFriends.kt */
            /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Long> {
                public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Long call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Long call2(Map.Entry<Long, Integer> entry) {
                    return entry.getKey();
                }
            }

            /* compiled from: WidgetGroupInviteFriends.kt */
            /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$3, reason: invalid class name */
            public static final class AnonymousClass3<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Integer> {
                public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Integer call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Integer call2(Map.Entry<Long, Integer> entry) {
                    return entry.getValue();
                }
            }

            public C02411(Map map) {
                this.$relationships = map;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends User> map) {
                return call2(map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, Integer>> call2(Map<Long, ? extends User> map) {
                return Observable.B(this.$relationships.entrySet()).y(new C02421(map)).g0(AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE);
            }
        }

        public AnonymousClass1(List list) {
            this.$excludeUserIds = list;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, Integer>> call2(Map<Long, Integer> map) {
            return StoreStream.INSTANCE.getUsers().observeUsers(map.keySet()).Y(new C02411(map));
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2(String str) {
        this.$nameFilter = str;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(List<Long> list) {
        return call2(list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, Integer>> call2(List<Long> list) {
        return StoreStream.INSTANCE.getUserRelationships().observeForType(1).Y(new AnonymousClass1(list));
    }
}
