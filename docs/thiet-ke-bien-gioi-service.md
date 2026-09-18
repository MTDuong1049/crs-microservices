# Thiết kế biên giới Service (CRS Microservices)

## 1. Danh sách Service
- **api-gateway** (Port: 8080, không có DB): Điểm vào duy nhất, định tuyến, xác thực sơ bộ, CORS.
- **auth-service** (Port: 8081, DB: auth_db): Quản lý User, Student, đăng nhập, sinh/xác thực JWT.
- **course-service** (Port: 8082, DB: course_db): Quản lý Course, tìm kiếm, phân trang, quản lý số chỗ.
- **registration-service** (Port: 8083, DB: registration_db): Quản lý Registration, gọi sang course-service để đăng ký.

## 2. Nguyên tắc sở hữu dữ liệu (Data Ownership)
- Mỗi service sở hữu DATABASE RIÊNG, KHÔNG truy cập trực tiếp DB của nhau.
- Mọi trao đổi dữ liệu bắt buộc thông qua REST API.
- Ví dụ: `registration-service` chỉ lưu `courseId` (kiểu số), không lưu bảng Course hay khóa ngoại thật.

## 3. Bảng định tuyến Gateway (Dự kiến)
- `/api/auth/**` -> `http://localhost:8081` (Public login/register, phần còn lại dùng JWT)
- `/api/courses/**` -> `http://localhost:8082` (GET public; POST/PUT/DELETE cần role ADMIN)
- `/api/registrations/**` -> `http://localhost:8083` (Cần JWT - STUDENT/ADMIN)
- `/api/public/courses` -> `http://localhost:8082` (Dùng API Key cho đối tác ngoài)