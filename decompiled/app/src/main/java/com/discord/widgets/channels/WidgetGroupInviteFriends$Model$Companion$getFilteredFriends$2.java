package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import java.util.List;
import java.util.Map;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2<T, R> implements Func1<List<Long>, Observable<? extends Map<Long, Integer>>> {
    public final /* synthetic */ String $nameFilter;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class C73781<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends Map<Long, Integer>>> {
        public final /* synthetic */ List $excludeUserIds;

        /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends User>, Observable<? extends Map<Long, Integer>>> {
            public final /* synthetic */ Map $relationships;

            /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
            public static final class C132741<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Boolean> {
                public final /* synthetic */ Map $users;

                public C132741(Map map) {
                    this.$users = map;
                }

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Boolean call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean call2(Map.Entry<Long, Integer> entry) {
                    boolean zContains;
                    User user;
                    String username;
                    boolean z2 = true;
                    if (C73781.this.$excludeUserIds.contains(entry.getKey()) || !this.$users.containsKey(entry.getKey())) {
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

            /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
            public static final class AnonymousClass2<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Long> {
                public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Long call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Long call2(Map.Entry<Long, Integer> entry) {
                    return entry.getKey();
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
            public static final class AnonymousClass3<T, R> implements Func1<Map.Entry<? extends Long, ? extends Integer>, Integer> {
                public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Integer call(Map.Entry<? extends Long, ? extends Integer> entry) {
                    return call2((Map.Entry<Long, Integer>) entry);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Integer call2(Map.Entry<Long, Integer> entry) {
                    return entry.getValue();
                }
            }

            public AnonymousClass1(Map map) {
                this.$relationships = map;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends User> map) {
                return call2(map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Map<Long, Integer>> call2(Map<Long, ? extends User> map) {
                return Observable.m11058B(this.$relationships.entrySet()).m11118y(new C132741(map)).m11106g0(AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE);
            }
        }

        public C73781(List list) {
            this.$excludeUserIds = list;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, Integer>> call2(Map<Long, Integer> map) {
            return StoreStream.INSTANCE.getUsers().observeUsers(map.keySet()).m11099Y(new AnonymousClass1(map));
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2(String str) {
        this.$nameFilter = str;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, Integer>> call(List<Long> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, Integer>> call2(List<Long> list) {
        return StoreStream.INSTANCE.getUserRelationships().observeForType(1).m11099Y(new C73781(list));
    }
}
