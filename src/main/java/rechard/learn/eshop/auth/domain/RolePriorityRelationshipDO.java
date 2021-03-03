package rechard.learn.eshop.auth.domain;

/**
 * 角色和权限之间的关系类
 */
public class RolePriorityRelationshipDO {
        private int id;
        //角色id
        private int roleId;
        //权限id
        private int priorityId;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getRoleId() {
                return roleId;
        }

        public void setRoleId(int roleId) {
                this.roleId = roleId;
        }

        public int getPriorityId() {
                return priorityId;
        }

        public void setPriorityId(int priorityId) {
                this.priorityId = priorityId;
        }
}
