# Blueprint API

## 1. auth-service (Port 8081 | Prefix: /api/auth)
- `POST /auth/login` - Đăng nhập, trả về JWT (Public)
- `POST /auth/register` - Đăng ký tài khoản (Public)

## 2. course-service (Port 8082 | Prefix: /api/courses)
- `GET /courses` - Danh sách môn học, phân trang & tìm kiếm (Public)
- `GET /courses/{id}` - Chi tiết môn học (Public)
- `POST /courses` - Thêm môn học (ADMIN)
- `PUT /courses/{id}` - Sửa môn học (ADMIN)
- `DELETE /courses/{id}` - Xóa môn học (ADMIN)

### API Nội bộ (Internal API - không qua Gateway):
- `PATCH /internal/courses/{id}/reserve-seat` - Giữ/Trừ chỗ khi đăng ký
- `PATCH /internal/courses/{id}/release-seat` - Hoàn chỗ khi hủy đăng ký

## 3. registration-service (Port 8083 | Prefix: /api/registrations)
- `POST /registrations` - Đăng ký học phần (STUDENT)
- `GET /registrations/my` - Xem danh sách môn đã đăng ký của tôi (STUDENT)
- `DELETE /registrations/{id}` - Hủy đăng ký học phần (STUDENT/ADMIN)