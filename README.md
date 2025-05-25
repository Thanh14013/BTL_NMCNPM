# BlueMoon Apartment Management System

A comprehensive apartment complex management application built with Java Swing and MySQL, designed to streamline residential property administration and fee management.

## 🏢 Project Overview

BlueMoon Apartment Management System is a desktop application that provides complete management capabilities for apartment complexes, including resident registration, household management, fee collection, and statistical reporting.

## ✨ Key Features

### 👥 Resident Management (`NhanKhau`)

- Add, edit, and delete resident information
- Track resident status (permanent, temporary residence, temporary absence)
- Store personal details (ID, phone, birth date)
- Link residents to households

### 🏠 Household Management (`HoKhau`)

- Register and manage household information
- Track household head details and family members
- Record apartment specifications (area, parking slots for cars/motorcycles)
- Automatic fee calculation based on property specifications

### 💰 Fee Management (`KhoanPhi`)

- Multiple fee categories management
- Automatic fee calculation for:
  - Car parking fees (70,000 VND per slot)
  - Motorcycle parking fees (1,200,000 VND per slot)
  - Utility fees and maintenance charges
- Fee update and payment tracking

### 📊 Statistics & Reporting (`ThongKe`)

- Real-time dashboard with key metrics:
  - Total households count
  - Total residents count
  - Temporary residence count
  - Temporary absence count
- Payment history tracking (`LichSu`)
- Financial reporting and analytics

### 🔐 Authentication System

- Secure login functionality
- User session management
- Database-driven authentication

## 🛠️ Technical Stack

- **Frontend**: Java Swing (Desktop GUI)
- **Backend**: Java SE
- **Database**: MySQL
- **Server**: XAMPP
- **Build Tool**: Apache Ant (NetBeans project)
- **Dependencies**:
  - MySQL Connector J 9.1.0
  - JCalendar 1.4

## 🏗️ Architecture

The application follows a layered architecture pattern:

```
src/scr/
├── controller/     # Business logic controllers
│   ├── LoginController.java
│   ├── MainController.java
│   ├── HoKhauController.java
│   ├── NhanKhauController.java
│   ├── KhoanPhiController.java
│   ├── ThongKeController.java
│   └── LichSuController.java
├── dao/           # Data Access Objects
│   ├── connect_to_db.java
│   ├── HoKhauDaoimpl.java
│   ├── NhanKhauDaoimpl.java
│   ├── KhoanPhiDaoimpl.java
│   ├── LichSuDaoimpl.java
│   └── ThongKeDaoimpl.java
├── model/         # Data models
│   ├── HoKhau.java
│   ├── NhanKhau.java
│   ├── KhoanPhi.java
│   ├── LichSu.java
│   ├── ThongKe.java
│   └── TaiKhoan.java
├── service/       # Business logic layer
│   ├── HoKhauService.java
│   ├── NhanKhauService.java
│   ├── KhoanPhiService.java
│   ├── LichSuService.java
│   └── ThongKeService.java
├── utility/       # Table utilities
│   ├── HoKhauTable.java
│   ├── NhanKhauTable.java
│   ├── KhoanPhiTable.java
│   ├── LichSuTable.java
│   └── ThongKeTable.java
├── view/          # GUI components
│   ├── MainJFrame.java
│   ├── DangNhapJDialog.java
│   ├── BangThongKeJFrame.java
│   └── Various management panels
└── main/          # Application entry point
    └── main.java
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- XAMPP with MySQL
- NetBeans IDE (recommended)

### Installation

1. **Clone the repository**

   ```powershell
   git clone [repository-url]
   cd BlueMoon-Apartment-Management
   ```

2. **Set up Database**

   - Start XAMPP and ensure MySQL is running
   - Import the database schema from `quanlychungcu.sql`
   - Create database named `quanlychungcu`
   - Update database connection settings in `connect_to_db.java` if needed

3. **Configure Dependencies**

   - Dependencies are already included in `disc/lib/` directory:
     - `mysql-connector-j-9.1.0.jar`
     - `jcalendar-1.4.jar`

4. **Build and Run**

   ```powershell
   # Using Ant build script
   ant clean
   ant compile
   ant jar

   # Or run the pre-built JAR
   java -jar "disc/QLyChungCu.jar"
   ```

5. **Run from NetBeans**
   - Open the project in NetBeans IDE
   - Main class: `scr.main.main`
   - Press F6 to run

## 💾 Database Schema

The system uses a MySQL database with the following main tables:

- `hokhau` - Household information
- `nhankhau` - Resident information
- `khoanphi` - Fee categories
- `hokhau_khoanphi` - Household fee assignments
- `lichsu` - Payment history
- `thongke` - Statistics and reporting
- `taikhoan` - User accounts

**Database Setup:**

```sql
-- Import the provided SQL file
mysql -u root -p quanlychungcu < quanlychungcu.sql
```

## 🔧 Configuration

### Database Connection

Default connection settings in `connect_to_db.java`:

```java
String url = "jdbc:mysql://localhost:3306/quanlychungcu";
String user = "root";
String password = "";
```

### Build Configuration

Project uses Apache Ant build system with the following structure:

- Source: `src/`
- Build: `build/`
- Distribution: `disc/`
- Libraries: `disc/lib/`

## 📱 User Interface

The application features:

- **Login Dialog**: Secure authentication interface (`DangNhapJDialog`)
- **Main Dashboard**: Overview with navigation menu (`MainJFrame`)
- **Management Panels**:
  - Household management
  - Resident management
  - Fee management
  - Payment history
- **Statistical Views**: Real-time reporting and analytics (`BangThongKeJFrame`)

## 🎯 Core Functionality

### MVC Architecture Implementation

- **Models**: Data entities for all business objects
- **Views**: Swing-based user interfaces with form designers
- **Controllers**: Business logic coordination between views and services
- **Services**: Business logic implementation
- **DAOs**: Database access layer with MySQL integration

### Key Controllers

- `MainController` - Application navigation and main window
- `HoKhauController` - Household management operations
- `NhanKhauController` - Resident management operations
- `KhoanPhiController` - Fee management operations
- `ThongKeController` - Statistics and reporting
- `LichSuController` - Payment history management

## 🔍 Features Demonstration

This project showcases:

- **Desktop Application Development** with Java Swing
- **Database Design** and MySQL integration
- **MVC Architecture** implementation
- **Business Logic** for property management domain
- **GUI Design** with form builders and custom components
- **Data Validation** and error handling
- **Reporting Systems** with statistical analysis

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Project Structure Details

```
├── build.xml                 # Ant build configuration
├── quanlychungcu.sql         # Database schema and sample data
├── src/                      # Source code
├── build/                    # Compiled classes
├── disc/                     # Distribution files
│   ├── QLyChungCu.jar       # Executable JAR
│   └── lib/                 # External libraries
└── nbproject/               # NetBeans project files
```

## 📄 License

This project is developed as an educational/demonstration application for apartment management systems.

## 👨‍💻 Developer

Developed as a comprehensive solution demonstrating modern Java desktop application development practices for real estate management scenarios.

---

_This system demonstrates proficiency in Java desktop application development, database design, MVC architecture implementation, and business logic development for property management domains._
