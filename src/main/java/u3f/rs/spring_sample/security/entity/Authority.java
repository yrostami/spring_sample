package u3f.rs.spring_sample.security.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    USER(101),ADMIN(201);


    private int id;

    private Authority(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Authority fromId(int xid){
        switch(xid){
            case 101: return Authority.USER;
            case 201: return Authority.ADMIN;

            default:
                throw new IllegalArgumentException("Id ("+xid+") not supported");
        }
    }

    @Override
    public String getAuthority() {
        return this.name();
    }
}
